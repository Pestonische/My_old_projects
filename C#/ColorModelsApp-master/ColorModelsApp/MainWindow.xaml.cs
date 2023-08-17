using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using ColorModelsApp.ColorModels;
using Xceed.Wpf.Toolkit;
using MessageBox = System.Windows.MessageBox;

namespace ColorModelsApp
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private bool update = false;

        private List<(Slider Slider, TextBox TB, ColorModel ColorModel)> controllers;

        public MainWindow()
        {
            InitializeComponent();
            
            controllers = new List<(Slider Slider, TextBox TB, ColorModel ColorModel)>
            {
                new (CmykCyan, CmykCyanInput, ColorModel.Cmyk),
                new (CmykMagenta, CmykMagentaInput, ColorModel.Cmyk),
                new (CmykYellow, CmykYellowInput, ColorModel.Cmyk),
                new (CmykBlackKey, CmykBlackKeyInput, ColorModel.Cmyk),
                new (RgbRed, RgbRedInput, ColorModel.Rgb),
                new (RgbBlue, RgbBlueInput, ColorModel.Rgb),
                new (RgbGreen, RgbGreenInput, ColorModel.Rgb),
                new (HlsHue, HlsHueInput, ColorModel.Hls),
                new (HlsSaturation, HlsSaturationInput, ColorModel.Hls),
                new (HlsLightness, HlsValueInput, ColorModel.Hls),
            };

            UpdateColor(ColorModel.Rgb);
        }

        private void Color_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            var (currentSlider, currentTextBox, model) = GetControls(sender);
            currentSlider.SelectionEnd = currentSlider.Value;
            currentTextBox.SetText(currentSlider.Value);
            UpdateColor(model);
        }

        private void Color_TextChanged(object sender, TextChangedEventArgs e)
        {
            var (currentSlider, currentTextBox, model) = GetControls(sender);
            var text = currentTextBox.Text;

            if (string.IsNullOrWhiteSpace(text))
            {
                text = "0";
            }

            var real = -1f;
            short value = -1;

            switch (model)
            {
                case ColorModel.Cmyk:
                    if (!Single.TryParse(text, out real))
                    {
                        MessageBox.Show($"Not correct value. Expected value: integer from 0 to 100. But actual value was: {text}.");
                        currentTextBox.SetText(currentSlider.Value);
                        return;
                    }
                    real.ValidateInterval(0, 100);
                    break;
                case ColorModel.Rgb:
                    if (!Int16.TryParse(text, out value))
                    {
                        MessageBox.Show($"Not correct value. Expected value: integer from 0 to 255. But actual value was: {text}.");
                        currentTextBox.SetText(currentSlider.Value);
                        return;
                    }
                    real = value;
                    real.ValidateInterval(0, 255);
                    break;
                case ColorModel.Hls:
                    if (currentTextBox == HlsHueInput)
                    {
                        if (!Int16.TryParse(text, out value))
                        {
                            MessageBox.Show($"Not correct value. Expected value: integer from 0 to 359. But actual value was: {text}.");
                            currentTextBox.SetText(currentSlider.Value);
                            return;
                        }
                        real = value;
                        real.ValidateInterval(0, 359);
                    }
                    else
                    {
                        if (!Single.TryParse(text, out real))
                        {
                            MessageBox.Show($"Not correct value. Expected value: integer from 0 to 100. But actual value was: {text}.");
                            currentTextBox.SetText(currentSlider.Value);
                            return;
                        }
                        real.ValidateInterval(0, 100);
                    }
                    break;
            }

            currentSlider.Value = real;

            UpdateColor(model);
        }

        private void UpdateColor(ColorModel model)
        {
            if (!update)
            {
                update = true;
                UpdateColor(ColorModel.Rgb);
            }
            else
            {
                return;
            }

            RgbModel rgb = null!;

            switch (model)
            {
                case ColorModel.Cmyk:
                    var cmyk = new CmykModel((float)CmykCyan.Value, (float)CmykMagenta.Value, (float)CmykYellow.Value, (float)CmykBlackKey.Value);
                    rgb = cmyk.ToRgb();
                    SetRgb(rgb);
                    SetHls(cmyk.ToHls());
                    break;
                case ColorModel.Rgb:
                    rgb = new RgbModel((byte)RgbRed.Value, (byte)RgbGreen.Value, (byte)RgbBlue.Value);
                    SetCmyk(rgb.ToCmyk());
                    SetHls(rgb.ToHls());
                    break;
                case ColorModel.Hls:
                    var hls = new HlsModel((short)HlsHue.Value, (float)HlsSaturation.Value, (float)HlsLightness.Value);
                    rgb = hls.ToRgb();
                    SetRgb(rgb);
                    SetCmyk(hls.ToCmyk());
                    break;
            }

            UpdateInputs();

            var color = Color.FromRgb(rgb.Red, rgb.Green, rgb.Blue);
            ResultColor.Fill = new SolidColorBrush(color);
            ColorPicker.SelectedColor = color;
            update = false;
        }

        private (Slider Slider, TextBox TB, ColorModel ColorModel) GetControls(object sender)
        {
            foreach (var pair in controllers)
            {
                if (pair.Slider == sender || pair.TB == sender)
                {
                    return pair;
                }
            }

            throw new Exception("Not correct sender.");
        }

        private void SetCmyk(CmykModel model)
        {
            CmykCyan.Value = model.Cyan;
            CmykMagenta.Value = model.Magenta;
            CmykYellow.Value = model.Yellow;
            CmykBlackKey.Value = model.BlackKey;
        }

        private void SetRgb(RgbModel model)
        {
            RgbRed.Value = model.Red;
            RgbGreen.Value = model.Green;
            RgbBlue.Value = model.Blue;
        }

        private void SetHls(HlsModel model)
        {
            HlsHue.Value = model.Hue;
            HlsSaturation.Value = model.Saturation;
            HlsLightness.Value = model.Lightness;
        }

        private void UpdateInputs()
        {
            foreach (var pair in controllers)
            {
                pair.TB.SetText(pair.Slider.Value);
            }
        }

        private void ColorPicker_OnSelectedColorChanged(object sender, RoutedPropertyChangedEventArgs<Color?> e)
        {
            var color = ColorPicker.SelectedColor.Value;
            SetRgb(new RgbModel(color.R, color.G, color.B));
            UpdateColor(ColorModel.Rgb);
        }
    }
}
