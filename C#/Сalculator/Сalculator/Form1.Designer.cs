namespace Сalculator
{
    partial class Calculator
    {
        /// <summary>
        /// Обязательная переменная конструктора.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Освободить все используемые ресурсы.
        /// </summary>
        /// <param name="disposing">истинно, если управляемый ресурс должен быть удален; иначе ложно.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Код, автоматически созданный конструктором форм Windows

        /// <summary>
        /// Требуемый метод для поддержки конструктора — не изменяйте 
        /// содержимое этого метода с помощью редактора кода.
        /// </summary>
        private void InitializeComponent()
        {
            this.TFirstNumber = new System.Windows.Forms.TextBox();
            this.TSecondNumber = new System.Windows.Forms.TextBox();
            this.BPlus = new System.Windows.Forms.Button();
            this.BMinus = new System.Windows.Forms.Button();
            this.BMultiplizieren = new System.Windows.Forms.Button();
            this.BDivision = new System.Windows.Forms.Button();
            this.BGleich = new System.Windows.Forms.Button();
            this.TResult = new System.Windows.Forms.TextBox();
            this.LFirstNumber = new System.Windows.Forms.Label();
            this.LSecondNumber = new System.Windows.Forms.Label();
            this.Result = new System.Windows.Forms.Label();
            this.BСlear = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // TFirstNumber
            // 
            this.TFirstNumber.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(224)))), ((int)(((byte)(224)))), ((int)(((byte)(224)))));
            this.TFirstNumber.Font = new System.Drawing.Font("Microsoft Sans Serif", 16.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.TFirstNumber.Location = new System.Drawing.Point(17, 173);
            this.TFirstNumber.Name = "TFirstNumber";
            this.TFirstNumber.Size = new System.Drawing.Size(230, 38);
            this.TFirstNumber.TabIndex = 0;
            // 
            // TSecondNumber
            // 
            this.TSecondNumber.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(224)))), ((int)(((byte)(224)))), ((int)(((byte)(224)))));
            this.TSecondNumber.Font = new System.Drawing.Font("Microsoft Sans Serif", 16.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.TSecondNumber.Location = new System.Drawing.Point(260, 173);
            this.TSecondNumber.Name = "TSecondNumber";
            this.TSecondNumber.Size = new System.Drawing.Size(242, 38);
            this.TSecondNumber.TabIndex = 1;
            // 
            // BPlus
            // 
            this.BPlus.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(128)))), ((int)(((byte)(255)))));
            this.BPlus.Font = new System.Drawing.Font("Microsoft Sans Serif", 25.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.BPlus.ForeColor = System.Drawing.Color.White;
            this.BPlus.Location = new System.Drawing.Point(17, 242);
            this.BPlus.Name = "BPlus";
            this.BPlus.Size = new System.Drawing.Size(242, 71);
            this.BPlus.TabIndex = 2;
            this.BPlus.Text = "+";
            this.BPlus.UseVisualStyleBackColor = false;
            this.BPlus.Click += new System.EventHandler(this.BPlus_Click);
            // 
            // BMinus
            // 
            this.BMinus.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(128)))), ((int)(((byte)(255)))));
            this.BMinus.Font = new System.Drawing.Font("Microsoft Sans Serif", 28.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.BMinus.ForeColor = System.Drawing.Color.White;
            this.BMinus.Location = new System.Drawing.Point(260, 242);
            this.BMinus.Name = "BMinus";
            this.BMinus.Size = new System.Drawing.Size(257, 71);
            this.BMinus.TabIndex = 3;
            this.BMinus.Text = "-";
            this.BMinus.UseVisualStyleBackColor = false;
            this.BMinus.Click += new System.EventHandler(this.BMinus_Click);
            // 
            // BMultiplizieren
            // 
            this.BMultiplizieren.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(128)))), ((int)(((byte)(255)))));
            this.BMultiplizieren.Font = new System.Drawing.Font("Microsoft Sans Serif", 36F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.BMultiplizieren.ForeColor = System.Drawing.Color.White;
            this.BMultiplizieren.Location = new System.Drawing.Point(17, 319);
            this.BMultiplizieren.Name = "BMultiplizieren";
            this.BMultiplizieren.Size = new System.Drawing.Size(242, 66);
            this.BMultiplizieren.TabIndex = 4;
            this.BMultiplizieren.Text = "*";
            this.BMultiplizieren.UseVisualStyleBackColor = false;
            this.BMultiplizieren.Click += new System.EventHandler(this.BMultiplizieren_Click);
            // 
            // BDivision
            // 
            this.BDivision.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(128)))), ((int)(((byte)(255)))));
            this.BDivision.Font = new System.Drawing.Font("Microsoft Sans Serif", 25.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.BDivision.ForeColor = System.Drawing.Color.White;
            this.BDivision.Location = new System.Drawing.Point(260, 319);
            this.BDivision.Name = "BDivision";
            this.BDivision.Size = new System.Drawing.Size(257, 66);
            this.BDivision.TabIndex = 5;
            this.BDivision.Text = "/";
            this.BDivision.UseVisualStyleBackColor = false;
            this.BDivision.Click += new System.EventHandler(this.BDivision_Click);
            // 
            // BGleich
            // 
            this.BGleich.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(128)))), ((int)(((byte)(255)))));
            this.BGleich.Font = new System.Drawing.Font("Microsoft Sans Serif", 25.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.BGleich.ForeColor = System.Drawing.Color.White;
            this.BGleich.Location = new System.Drawing.Point(262, 391);
            this.BGleich.Name = "BGleich";
            this.BGleich.Size = new System.Drawing.Size(255, 62);
            this.BGleich.TabIndex = 6;
            this.BGleich.Text = "=";
            this.BGleich.UseVisualStyleBackColor = false;
            this.BGleich.Click += new System.EventHandler(this.BGleich_Click);
            // 
            // TResult
            // 
            this.TResult.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(224)))), ((int)(((byte)(224)))), ((int)(((byte)(224)))));
            this.TResult.Font = new System.Drawing.Font("Microsoft Sans Serif", 16.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.TResult.Location = new System.Drawing.Point(17, 52);
            this.TResult.Name = "TResult";
            this.TResult.Size = new System.Drawing.Size(500, 38);
            this.TResult.TabIndex = 7;
            // 
            // LFirstNumber
            // 
            this.LFirstNumber.AutoSize = true;
            this.LFirstNumber.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.LFirstNumber.Location = new System.Drawing.Point(12, 135);
            this.LFirstNumber.Name = "LFirstNumber";
            this.LFirstNumber.Size = new System.Drawing.Size(146, 25);
            this.LFirstNumber.TabIndex = 8;
            this.LFirstNumber.Text = "Первое число:";
            // 
            // LSecondNumber
            // 
            this.LSecondNumber.AutoSize = true;
            this.LSecondNumber.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.LSecondNumber.Location = new System.Drawing.Point(257, 135);
            this.LSecondNumber.Name = "LSecondNumber";
            this.LSecondNumber.Size = new System.Drawing.Size(146, 25);
            this.LSecondNumber.TabIndex = 9;
            this.LSecondNumber.Text = "Второе число:";
            // 
            // Result
            // 
            this.Result.AutoSize = true;
            this.Result.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.Result.Location = new System.Drawing.Point(12, 24);
            this.Result.Name = "Result";
            this.Result.Size = new System.Drawing.Size(117, 25);
            this.Result.TabIndex = 10;
            this.Result.Text = "Результат:";
            // 
            // BСlear
            // 
            this.BСlear.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(128)))), ((int)(((byte)(255)))));
            this.BСlear.Font = new System.Drawing.Font("Microsoft Sans Serif", 25.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.BСlear.ForeColor = System.Drawing.Color.White;
            this.BСlear.Location = new System.Drawing.Point(17, 391);
            this.BСlear.Name = "BСlear";
            this.BСlear.Size = new System.Drawing.Size(239, 62);
            this.BСlear.TabIndex = 11;
            this.BСlear.Text = "С";
            this.BСlear.UseVisualStyleBackColor = false;
            this.BСlear.Click += new System.EventHandler(this.BСlear_Click);
            // 
            // Calculator
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Lime;
            this.ClientSize = new System.Drawing.Size(534, 465);
            this.Controls.Add(this.BСlear);
            this.Controls.Add(this.Result);
            this.Controls.Add(this.LSecondNumber);
            this.Controls.Add(this.LFirstNumber);
            this.Controls.Add(this.TResult);
            this.Controls.Add(this.BGleich);
            this.Controls.Add(this.BDivision);
            this.Controls.Add(this.BMultiplizieren);
            this.Controls.Add(this.BMinus);
            this.Controls.Add(this.BPlus);
            this.Controls.Add(this.TSecondNumber);
            this.Controls.Add(this.TFirstNumber);
            this.Name = "Calculator";
            this.Text = "Калькулятор";
            this.Load += new System.EventHandler(this.Calculator_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox TFirstNumber;
        private System.Windows.Forms.TextBox TSecondNumber;
        private System.Windows.Forms.Button BPlus;
        private System.Windows.Forms.Button BMinus;
        private System.Windows.Forms.Button BMultiplizieren;
        private System.Windows.Forms.Button BDivision;
        private System.Windows.Forms.Button BGleich;
        private System.Windows.Forms.TextBox TResult;
        private System.Windows.Forms.Label LFirstNumber;
        private System.Windows.Forms.Label LSecondNumber;
        private System.Windows.Forms.Label Result;
        private System.Windows.Forms.Button BСlear;
    }
}

