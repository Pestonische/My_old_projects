namespace events
{
    partial class FEvents
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
            this.BStart = new System.Windows.Forms.Button();
            this.BFinish = new System.Windows.Forms.Button();
            this.RTBResult = new System.Windows.Forms.RichTextBox();
            this.LTime = new System.Windows.Forms.Label();
            this.TTime = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // BStart
            // 
            this.BStart.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(0)))));
            this.BStart.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.BStart.ForeColor = System.Drawing.Color.White;
            this.BStart.Location = new System.Drawing.Point(1, 49);
            this.BStart.Name = "BStart";
            this.BStart.Size = new System.Drawing.Size(417, 49);
            this.BStart.TabIndex = 0;
            this.BStart.Text = "Начать";
            this.BStart.UseVisualStyleBackColor = false;
            this.BStart.Click += new System.EventHandler(this.BStart_Click);
            // 
            // BFinish
            // 
            this.BFinish.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(0)))));
            this.BFinish.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.BFinish.ForeColor = System.Drawing.Color.White;
            this.BFinish.Location = new System.Drawing.Point(414, 49);
            this.BFinish.Name = "BFinish";
            this.BFinish.Size = new System.Drawing.Size(386, 49);
            this.BFinish.TabIndex = 4;
            this.BFinish.Text = "Остановить";
            this.BFinish.UseVisualStyleBackColor = false;
            this.BFinish.Click += new System.EventHandler(this.BFinish_Click);
            // 
            // RTBResult
            // 
            this.RTBResult.BackColor = System.Drawing.SystemColors.Info;
            this.RTBResult.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.RTBResult.Location = new System.Drawing.Point(1, 104);
            this.RTBResult.Name = "RTBResult";
            this.RTBResult.Size = new System.Drawing.Size(799, 346);
            this.RTBResult.TabIndex = 5;
            this.RTBResult.Text = "";
            // 
            // LTime
            // 
            this.LTime.AutoSize = true;
            this.LTime.Font = new System.Drawing.Font("Microsoft Sans Serif", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.LTime.ForeColor = System.Drawing.Color.White;
            this.LTime.Location = new System.Drawing.Point(29, 9);
            this.LTime.Name = "LTime";
            this.LTime.Size = new System.Drawing.Size(232, 29);
            this.LTime.TabIndex = 6;
            this.LTime.Text = "Введите задержку:";
            // 
            // TTime
            // 
            this.TTime.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.TTime.Location = new System.Drawing.Point(275, 9);
            this.TTime.Multiline = true;
            this.TTime.Name = "TTime";
            this.TTime.Size = new System.Drawing.Size(220, 29);
            this.TTime.TabIndex = 7;
            // 
            // FEvents
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(0)))), ((int)(((byte)(64)))));
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.TTime);
            this.Controls.Add(this.LTime);
            this.Controls.Add(this.RTBResult);
            this.Controls.Add(this.BFinish);
            this.Controls.Add(this.BStart);
            this.Name = "FEvents";
            this.Text = "Обработка событий ";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.Form1_FormClosing);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button BStart;
        private System.Windows.Forms.Button BFinish;
        private System.Windows.Forms.RichTextBox RTBResult;
        private System.Windows.Forms.Label LTime;
        private System.Windows.Forms.TextBox TTime;
    }
}

