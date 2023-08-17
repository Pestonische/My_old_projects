import UIKit

class Rhombus {
    func path(_ size: CGSize) -> UIBezierPath {
        let path = UIBezierPath()
        path.move(to: CGPoint(x: size.width / 2, y: 1))
        path.addLine(to: CGPoint(x: size.width - 1, y: size.height - 1))
        path.addLine(to: CGPoint(x: 1, y: size.height - 1))
        path.close()
        return path
    }
}

@IBDesignable class RhombusView: UIView {
    let shapeLayer = CAShapeLayer()
    
    public override func draw(_ rect : CGRect){
        shapeLayer.path = Rhombus().path(frame.size).cgPath
        shapeLayer.fillColor = UIColor.red.cgColor
        shapeLayer.strokeColor = UIColor.red.cgColor
        shapeLayer.lineWidth = 3.0
        shapeLayer.shadowRadius = 10.0
        shapeLayer.shadowOpacity = 0.8
        shapeLayer.shadowOffset = CGSize.zero
        layer.addSublayer(shapeLayer)
    }
}
