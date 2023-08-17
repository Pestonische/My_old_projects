using System.Windows.Controls;

namespace ColorModelsApp
{


    public static class Extensions
    {
        public static void SetText(this TextBox tb, double value)
        {
            if (value % 1 <= double.Epsilon)
            {
                tb.Text = ((int)value).ToString();
            }
            else
            {
                tb.Text = $"{value:f2}";
            }
        }

        public static void ValidateInterval(this float num, int down, int top)
        {
            if (num < down)
            {
                num = down;
            }
            if (num > top)
            {
                num = top;
            }
        }
    }
}