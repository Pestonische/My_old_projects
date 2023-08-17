import java.math.BigInteger
import java.nio.file.Files
import java.nio.file.Paths

class Hash(private val n: Int = 32) {

    private val y: String = "011110100111000110011000110010101".substring(0, n)



    fun getHash(filePath: String): ByteArray {
        val path = Paths.get(filePath)
        val messageBytes = Files.readAllBytes(path)
        val messageBits = parseBits(messageBytes)
        println("Archived message : $messageBits")
        val messageLenBits = messageBits.length
        val remainder = messageLenBits % n
        val m = if (n == 0) {
            0
        } else {
            n - remainder
        }
        val attachedMessage = attachMBits(messageBits, m)
        var blocks = divide(attachedMessage, n)
        val additionalBlock = formLastBlock(messageLenBits, n)
        blocks += additionalBlock
        var currentY = y.toUInt(radix = 2)
        for (block in blocks) {
            currentY = fynX(currentY, block)
        }
        println("Hash bits : ${currentY.toString(radix = 2)}")
        return convertToByteArray(currentY)
    }

    private fun convertToByteArray(y: UInt): ByteArray {
       val array = ByteArray(4)
        for(i in 0 until 4){
            val tmp1 = (y shr (i * 8)) and 255u
            array[i] = ((y shr (i * 8)) and 255u).toByte()
        }
        return array
    }


    private fun fynX(y: UInt, x: String): UInt {// bloc = (Fx(x^y)^y
        val block = x.toUInt(radix = 2)
        val key = block
        val cryptoSystem = GCryptoSystem(key.toInt(), ITERATIONS)
        val bytesBlock = convertToByteArray(block xor y)
        val encodedBytes = cryptoSystem.encodeBytes(bytesBlock)
        val encoded = BigInteger(encodedBytes).toInt().toUInt()
        return encoded xor y
    }

    //n
    private fun formLastBlock(messageLenBits: Int, n: Int): String {
        val bits = messageLenBits.toString(radix = 2)
        return "0".repeat(messageLenBits.countLeadingZeroBits()) + bits
    }

    private fun divide(attachedMessage: String, n: Int): Array<String> {
        var blocks = arrayOf<String>()
        for (i in attachedMessage.indices step n) {
            val block = attachedMessage.substring(i, i + n)
            blocks += block
        }
        return blocks
    }

    private fun parseBits(messageBytes: ByteArray): String {
        var result = ""
        for (byte in messageBytes) {
            val bits = byte.toUByte().toString(radix = 2)
            result += bits
        }
        return result
    }

    private fun attachMBits(messageBytes: String, m: Int): String {
        return messageBytes + "0".repeat(m)
    }
}