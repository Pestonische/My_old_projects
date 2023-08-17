import UIKit

struct Star {
    let corners: Int
    let smoothness: CGFloat
    
    func path(in rect: CGRect) -> UIBezierPath {
        guard corners >= 2 else { return UIBezierPath() }
        let center = CGPoint(x: rect.width / 2, y: rect.height / 2)
        var currentAngle = -CGFloat.pi / 2
        let angleAdjustment = .pi * 2 / CGFloat(corners)
        
        let path = UIBezierPath()
        
        path.move(to: CGPoint(x: center.x * cos(currentAngle), y: center.y * sin(currentAngle)))
        
        var bottomEdge: CGFloat = 0
        
        // loop over all our points/inner points
        for _ in 0..<corners  {
            let sinAngle = sin(currentAngle)
            let cosAngle = cos(currentAngle)
            let bottom: CGFloat
            bottom = center.y * sinAngle
            path.addLine(to: CGPoint(x: center.x * cosAngle, y: bottom))
            if bottom > bottomEdge {
                bottomEdge = bottom
            }
            
            currentAngle += angleAdjustment
        }
        
        let unusedSpace = (rect.height / 2 - bottomEdge) / 2
        
        let transform = CGAffineTransform(translationX: center.x, y: center.y + unusedSpace)
        path.apply(transform)
        return path
    }
}

@IBDesignable class StarView: UIView {
    let gradientLayer = CAGradientLayer()
    let shapeLayer = CAShapeLayer()
    
    public override func draw(_ rect: CGRect) {
        shapeLayer.path = Star.init(corners: 8, smoothness: 0.5).path(in: frame).cgPath
        shapeLayer.fillColor = UIColor.red.cgColor
        shapeLayer.strokeColor = UIColor.red.cgColor
        shapeLayer.lineWidth = 3.0
        shapeLayer.shadowRadius = 10.0
        shapeLayer.shadowOpacity = 0.8
        shapeLayer.shadowOffset = CGSize.zero
        layer.addSublayer(shapeLayer)
    }
}
