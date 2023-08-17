namespace Fool
{
    partial class GameForm
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
            this.BDa = new System.Windows.Forms.Button();
            this.BNo = new System.Windows.Forms.Button();
            this.QuestionBox = new System.Windows.Forms.TextBox();
            this.LQuestion = new System.Windows.Forms.Label();
            this.LYouFool = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // BDa
            // 
            this.BDa.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.BDa.Location = new System.Drawing.Point(208, 232);
            this.BDa.Name = "BDa";
            this.BDa.Size = new System.Drawing.Size(70, 50);
            this.BDa.TabIndex = 0;
            this.BDa.Text = "Да";
            this.BDa.UseVisualStyleBackColor = true;
            this.BDa.Click += new System.EventHandler(this.BDa_Click);
            this.BDa.MouseMove += new System.Windows.Forms.MouseEventHandler(this.GameForm_MouseMove);
            // 
            // BNo
            // 
            this.BNo.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.BNo.Cursor = System.Windows.Forms.Cursors.Hand;
            this.BNo.Location = new System.Drawing.Point(587, 232);
            this.BNo.Name = "BNo";
            this.BNo.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.BNo.Size = new System.Drawing.Size(70, 50);
            this.BNo.TabIndex = 1;
            this.BNo.TabStop = false;
            this.BNo.Text = "Нет";
            this.BNo.UseVisualStyleBackColor = true;
            this.BNo.Click += new System.EventHandler(this.BNo_Click);
            // 
            // QuestionBox
            // 
            this.QuestionBox.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.QuestionBox.Location = new System.Drawing.Point(320, 490);
            this.QuestionBox.Margin = new System.Windows.Forms.Padding(4);
            this.QuestionBox.Name = "QuestionBox";
            this.QuestionBox.Size = new System.Drawing.Size(200, 22);
            this.QuestionBox.TabIndex = 4;
            this.QuestionBox.TextChanged += new System.EventHandler(this.QuestionBox_TextChanged);
            this.QuestionBox.MouseMove += new System.Windows.Forms.MouseEventHandler(this.GameForm_MouseMove);
            // 
            // LQuestion
            // 
            this.LQuestion.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.LQuestion.AutoSize = true;
            this.LQuestion.Font = new System.Drawing.Font("Microsoft Sans Serif", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.LQuestion.Location = new System.Drawing.Point(281, 431);
            this.LQuestion.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.LQuestion.Name = "LQuestion";
            this.LQuestion.Size = new System.Drawing.Size(312, 29);
            this.LQuestion.TabIndex = 5;
            this.LQuestion.Text = "Сколько будет (21 / 7 - 2) ?";
            this.LQuestion.MouseMove += new System.Windows.Forms.MouseEventHandler(this.GameForm_MouseMove);
            // 
            // LYouFool
            // 
            this.LYouFool.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.LYouFool.AutoSize = true;
            this.LYouFool.Font = new System.Drawing.Font("Microsoft Sans Serif", 36F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.LYouFool.Location = new System.Drawing.Point(274, 117);
            this.LYouFool.Name = "LYouFool";
            this.LYouFool.Size = new System.Drawing.Size(323, 69);
            this.LYouFool.TabIndex = 0;
            this.LYouFool.Text = "Вы дурак?";
            this.LYouFool.MouseMove += new System.Windows.Forms.MouseEventHandler(this.GameForm_MouseMove);
            // 
            // GameForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.DimGray;
            this.ClientSize = new System.Drawing.Size(882, 653);
            this.Controls.Add(this.BNo);
            this.Controls.Add(this.LYouFool);
            this.Controls.Add(this.BDa);
            this.Controls.Add(this.LQuestion);
            this.Controls.Add(this.QuestionBox);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.MaximizeBox = false;
            this.Name = "GameForm";
            this.Text = "Дурак";
            this.MouseMove += new System.Windows.Forms.MouseEventHandler(this.GameForm_MouseMove);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button BDa;
        private System.Windows.Forms.Button BNo;
        private System.Windows.Forms.TextBox QuestionBox;
        private System.Windows.Forms.Label LQuestion;
        private System.Windows.Forms.Label LYouFool;
    }
}

