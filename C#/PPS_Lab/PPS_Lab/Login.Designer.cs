namespace PPS_Lab
{
    partial class Login
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
            this.cancelB = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.loginB = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.passwordL = new System.Windows.Forms.TextBox();
            this.userNameL = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // cancelB
            // 
            this.cancelB.Anchor = System.Windows.Forms.AnchorStyles.Top;
            this.cancelB.BackColor = System.Drawing.SystemColors.ActiveBorder;
            this.cancelB.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.cancelB.Location = new System.Drawing.Point(445, 343);
            this.cancelB.Name = "cancelB";
            this.cancelB.Size = new System.Drawing.Size(273, 54);
            this.cancelB.TabIndex = 0;
            this.cancelB.Text = "Cancel";
            this.cancelB.UseVisualStyleBackColor = false;
            this.cancelB.Click += new System.EventHandler(this.cancelB_Click);
            // 
            // label1
            // 
            this.label1.Anchor = System.Windows.Forms.AnchorStyles.Top;
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 36F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label1.Location = new System.Drawing.Point(324, 60);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(147, 55);
            this.label1.TabIndex = 1;
            this.label1.Text = "Login";
            // 
            // loginB
            // 
            this.loginB.Anchor = System.Windows.Forms.AnchorStyles.Top;
            this.loginB.BackColor = System.Drawing.SystemColors.ActiveBorder;
            this.loginB.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.loginB.Location = new System.Drawing.Point(71, 343);
            this.loginB.Name = "loginB";
            this.loginB.Size = new System.Drawing.Size(273, 54);
            this.loginB.TabIndex = 0;
            this.loginB.Text = "Login";
            this.loginB.UseVisualStyleBackColor = false;
            this.loginB.Click += new System.EventHandler(this.loginB_Click);
            // 
            // label2
            // 
            this.label2.Anchor = System.Windows.Forms.AnchorStyles.Top;
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label2.Location = new System.Drawing.Point(65, 191);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(158, 33);
            this.label2.TabIndex = 2;
            this.label2.Text = "User name";
            // 
            // label3
            // 
            this.label3.Anchor = System.Windows.Forms.AnchorStyles.Top;
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label3.Location = new System.Drawing.Point(65, 271);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(143, 33);
            this.label3.TabIndex = 3;
            this.label3.Text = "Password";
            // 
            // passwordL
            // 
            this.passwordL.Anchor = System.Windows.Forms.AnchorStyles.Top;
            this.passwordL.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.passwordL.Location = new System.Drawing.Point(229, 271);
            this.passwordL.Name = "passwordL";
            this.passwordL.Size = new System.Drawing.Size(489, 40);
            this.passwordL.TabIndex = 5;
            this.passwordL.TextChanged += new System.EventHandler(this.passwordL_TextChanged);
            // 
            // userNameL
            // 
            this.userNameL.Anchor = System.Windows.Forms.AnchorStyles.Top;
            this.userNameL.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.userNameL.Location = new System.Drawing.Point(229, 188);
            this.userNameL.Name = "userNameL";
            this.userNameL.Size = new System.Drawing.Size(489, 40);
            this.userNameL.TabIndex = 5;
            this.userNameL.TextChanged += new System.EventHandler(this.userNameL_TextChanged);
            // 
            // Login
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(784, 476);
            this.Controls.Add(this.userNameL);
            this.Controls.Add(this.passwordL);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.loginB);
            this.Controls.Add(this.cancelB);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "Login";
            this.Text = "Marks and tasks";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button cancelB;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button loginB;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox passwordL;
        private System.Windows.Forms.TextBox userNameL;
    }
}

