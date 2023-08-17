namespace SHOT
{
    partial class Shooting
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
            this.Menu = new System.Windows.Forms.GroupBox();
            this.BExit = new System.Windows.Forms.Button();
            this.LMisses = new System.Windows.Forms.Label();
            this.LHits = new System.Windows.Forms.Label();
            this.LShot = new System.Windows.Forms.Label();
            this.LaRadius = new System.Windows.Forms.Label();
            this.Menu.SuspendLayout();
            this.SuspendLayout();
            // 
            // Menu
            // 
            this.Menu.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(192)))), ((int)(((byte)(192)))));
            this.Menu.Controls.Add(this.BExit);
            this.Menu.Controls.Add(this.LMisses);
            this.Menu.Controls.Add(this.LHits);
            this.Menu.Controls.Add(this.LShot);
            this.Menu.Controls.Add(this.LaRadius);
            this.Menu.Cursor = System.Windows.Forms.Cursors.Arrow;
            this.Menu.Location = new System.Drawing.Point(0, 0);
            this.Menu.Name = "Menu";
            this.Menu.Size = new System.Drawing.Size(182, 527);
            this.Menu.TabIndex = 0;
            this.Menu.TabStop = false;
            // 
            // BExit
            // 
            this.BExit.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(255)))), ((int)(((byte)(128)))));
            this.BExit.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.BExit.Location = new System.Drawing.Point(12, 280);
            this.BExit.Name = "BExit";
            this.BExit.Size = new System.Drawing.Size(147, 65);
            this.BExit.TabIndex = 11;
            this.BExit.Text = "Прекратить стрельбу";
            this.BExit.UseVisualStyleBackColor = false;
            this.BExit.Click += new System.EventHandler(this.BExit_Click);
            // 
            // LMisses
            // 
            this.LMisses.AutoSize = true;
            this.LMisses.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.LMisses.Location = new System.Drawing.Point(12, 203);
            this.LMisses.Name = "LMisses";
            this.LMisses.Size = new System.Drawing.Size(118, 25);
            this.LMisses.TabIndex = 7;
            this.LMisses.Text = "Промахи: 0";
            // 
            // LHits
            // 
            this.LHits.AutoSize = true;
            this.LHits.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.LHits.Location = new System.Drawing.Point(8, 141);
            this.LHits.Name = "LHits";
            this.LHits.Size = new System.Drawing.Size(135, 25);
            this.LHits.TabIndex = 6;
            this.LHits.Text = "Попадания: 0";
            // 
            // LShot
            // 
            this.LShot.AutoSize = true;
            this.LShot.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.LShot.Location = new System.Drawing.Point(8, 78);
            this.LShot.Name = "LShot";
            this.LShot.Size = new System.Drawing.Size(130, 25);
            this.LShot.TabIndex = 1;
            this.LShot.Text = "Выстрелы: 0";
            // 
            // LaRadius
            // 
            this.LaRadius.AutoSize = true;
            this.LaRadius.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.LaRadius.Location = new System.Drawing.Point(7, 18);
            this.LaRadius.Name = "LaRadius";
            this.LaRadius.Size = new System.Drawing.Size(172, 50);
            this.LaRadius.TabIndex = 5;
            this.LaRadius.Text = "Текущий радиус: \r\n50";
            // 
            // Shooting
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.White;
            this.ClientSize = new System.Drawing.Size(782, 527);
            this.Controls.Add(this.Menu);
            this.Cursor = System.Windows.Forms.Cursors.Cross;
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "Shooting";
            this.ShowIcon = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Shooting";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.Shooting_FormClosing);
            this.Load += new System.EventHandler(this.Shooting_Load);
            this.Menu.ResumeLayout(false);
            this.Menu.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox Menu;
        private System.Windows.Forms.Label LMisses;
        private System.Windows.Forms.Label LHits;
        private System.Windows.Forms.Label LShot;
        private System.Windows.Forms.Button BExit;
        private System.Windows.Forms.Label LaRadius;
    }
}

