using System;

namespace ColorModelsApp.ColorModels
{

    public class RgbModel
    {
        public byte Red { get; init; } = 0;
        public byte Green { get; init; } = 0;
        public byte Blue { get; init; } = 0;

        public RgbModel() { }

        public RgbModel(byte red, byte green, byte blue)
        {
            this.Red = red;
            this.Green = green;
            this.Blue = blue;
        }

        public CmykModel ToCmyk()
        {
            var r = Red / 255f;
            var g = Green / 255f;
            var b = Blue / 255f;

            var k = 1 - Math.Max(r, Math.Max(g, b));

            if (Math.Abs(k - 1) <= float.Epsilon)
            {
                return new CmykModel(0, 0, 0, 100 * k);
            }

            var c = (1 - r - k) / (1 - k);
            var m = (1 - g - k) / (1 - k);
            var y = (1 - b - k) / (1 - k);

            return new CmykModel(100 * c, 100 * m, 100 * y, 100 * k);
        }

        public HlsModel ToHls()
        {
            var r = Red / 255f;
            var g = Green / 255f;
            var b = Blue / 255f;

            var max = Math.Max(r, Math.Max(g, b));
            var min = Math.Min(r, Math.Min(g, b));
            var d = max - min;

            var realH = 0f;

            if (Math.Abs(max - r) <= float.Epsilon)
            {
                realH = 60 * ((g - b) / d % 6);
            }
            else if (Math.Abs(max - g) <= float.Epsilon)
            {
                realH = 60 * ((b - r) / d + 2);
            }
            else if (Math.Abs(max - b) <= float.Epsilon)
            {
                realH = 60 * ((r - g) / d + 4);
            }

            var h = (short)Math.Round(realH);
            var s = max == 0 ? 0 : d / 1 - Math.Abs(max + min - 1);

            return new HlsModel(h, 100 * s, 50 * max + 50 * min);
        }
    }
}