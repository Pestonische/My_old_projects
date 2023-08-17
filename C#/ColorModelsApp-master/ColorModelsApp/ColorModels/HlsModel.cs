using System;

namespace ColorModelsApp.ColorModels
{

    public class HlsModel
    {
        public short Hue { get; init; } = 0;
        public float Saturation { get; init; } = 0;
        public float Lightness { get; init; } = 0;

        public HlsModel() { }

        public HlsModel(short hue, float saturation, float lightness)
        {
            this.Hue = hue;
            this.Saturation = saturation;
            this.Lightness = lightness;
        }

        public CmykModel ToCmyk()
        {
            var tempRgb = this.ToRgb();
            return tempRgb.ToCmyk();
        }

        public RgbModel ToRgb()
        {
            var c = (1 - Math.Abs(2 * Lightness/100 - 1)) * Saturation / 100;
            var x = c * (1 - Math.Abs(Hue / 60f % 2 - 1));
            var m = (Lightness / 100) - c / 2;

            var (realR, realG, realB) = (0f, 0f, 0f);

            if (Hue < 60)
            {
                (realR, realG, realB) = (c, x, 0);
            }
            else if (Hue < 120)
            {
                (realR, realG, realB) = (x, c, 0);
            }
            else if (Hue < 180)
            {
                (realR, realG, realB) = (0, c, x);
            }
            else if (Hue < 240)
            {
                (realR, realG, realB) = (0, x, c);
            }
            else if (Hue < 300)
            {
                (realR, realG, realB) = (x, 0, c);
            }
            else if (Hue < 360)
            {
                (realR, realG, realB) = (c, 0, x);
            }

            var (r, g, b) = ((byte)Math.Round((realR + m) * 255),
                (byte)Math.Round((realG + m) * 255),
                (byte)Math.Round((realB + m) * 255));

            return new RgbModel(r, g, b);
        }
    }
}