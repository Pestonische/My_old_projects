using System;

namespace ColorModelsApp.ColorModels
{

    public class CmykModel
    {
        public float Cyan { get; init; } = 0;
        public float Magenta { get; init; } = 0;
        public float Yellow { get; init; } = 0;
        public float BlackKey { get; init; } = 0;

        public CmykModel() { }

        public CmykModel(float cyan, float magenta, float yellow, float blackKey)
        {
            this.Cyan = cyan;
            this.Magenta = magenta;
            this.Yellow = yellow;
            this.BlackKey = blackKey;
        }

        public RgbModel ToRgb()
        {
            var c = Cyan / 100;
            var m = Magenta / 100;
            var y = Yellow / 100;
            var tmpK = 1 - BlackKey / 100;

            var R = 255 * (1 - c) * tmpK;
            var G = 255 * (1 - m) * tmpK;
            var B = 255 * (1 - y) * tmpK;

            var r = (byte)Math.Round(R);
            var g = (byte)Math.Round(G);
            var b = (byte)Math.Round(B);

            return new RgbModel(r, g, b);
        }

        public HlsModel ToHls()
        {
            var rgb = this.ToRgb();
            return rgb.ToHls();
        }
    }
}