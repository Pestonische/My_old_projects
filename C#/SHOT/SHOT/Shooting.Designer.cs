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
            this.BShot = new System.Windows.Forms.Button();
            this.TY = new System.Windows.Forms.TextBox();
            this.TX = new System.Windows.Forms.TextBox();
            this.LY = new System.Windows.Forms.Label();
            this.LX = new System.Windows.Forms.Label();
            this.LMisses = new System.Windows.Forms.Label();
            this.LHits = new System.Windows.Forms.Label();
            this.LShot = new System.Windows.Forms.Label();
            this.LaRadius = new System.Windows.Forms.Label();
            this.BRadius = new System.Windows.Forms.Button();
            this.TRadius = new System.Windows.Forms.TextBox();
            this.LRadius = new System.Windows.Forms.Label();
            this.Menu.SuspendLayout();
            this.SuspendLayout();
            // 
            // Menu
            // 
            this.Menu.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(192)))), ((int)(((byte)(192)))));
            this.Menu.Controls.Add(this.BShot);
            this.Menu.Controls.Add(this.TY);
            this.Menu.Controls.Add(this.TX);
            this.Menu.Controls.Add(this.LY);
            this.Menu.Controls.Add(this.LX);
            this.Menu.Controls.Add(this.LMisses);
            this.Menu.Controls.Add(this.LHits);
            this.Menu.Controls.Add(this.LShot);
            this.Menu.Controls.Add(this.LaRadius);
            this.Menu.Controls.Add(this.BRadius);
            this.Menu.Controls.Add(this.TRadius);
            this.Menu.Controls.Add(this.LRadius);
            this.Menu.Cursor = System.Windows.Forms.Cursors.Arrow;
            this.Menu.Location = new System.Drawing.Point(0, 0);
            this.Menu.Name = "Menu";
            this.Menu.Size = new System.Drawing.Size(182, 527);
            this.Menu.TabIndex = 0;
            this.Menu.TabStop = false;
            // 
            // BShot
            // 
            this.BShot.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(255)))), ((int)(((byte)(128)))));
            this.BShot.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.BShot.Location = new System.Drawing.Point(12, 458);
            this.BShot.Name = "BShot";
            this.BShot.Size = new System.Drawing.Size(147, 30);
            this.BShot.TabIndex = 11;
            this.BShot.Text = "Выстрел";
            this.BShot.UseVisualStyleBackColor = false;
            this.BShot.Click += new System.EventHandler(this.BShot_Click);
            // 
            // TY
            // 
            this.TY.Location = new System.Drawing.Point(14, 410);
            this.TY.Name = "TY";
            this.TY.Size = new System.Drawing.Size(147, 22);
            this.TY.TabIndex = 1;
            // 
            // TX
            // 
            this.TX.Location = new System.Drawing.Point(13, 347);
            this.TX.Name = "TX";
            this.TX.Size = new System.Drawing.Size(147, 22);
            this.TX.TabIndex = 10;
            // 
            // LY
            // 
            this.LY.AutoSize = true;
            this.LY.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.LY.Location = new System.Drawing.Point(9, 382);
            this.LY.Name = "LY";
            this.LY.Size = new System.Drawing.Size(151, 25);
            this.LY.TabIndex = 9;
            this.LY.Text = "Координаты Y:";
            // 
            // LX
            // 
            this.LX.AutoSize = true;
            this.LX.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.LX.Location = new System.Drawing.Point(8, 319);
            this.LX.Name = "LX";
            this.LX.Size = new System.Drawing.Size(152, 25);
            this.LX.TabIndex = 8;
            this.LX.Text = "Координаты X:";
            // 
            // LMisses
            // 
            this.LMisses.AutoSize = true;
            this.LMisses.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.LMisses.Location = new System.Drawing.Point(9, 283);
            this.LMisses.Name = "LMisses";
            this.LMisses.Size = new System.Drawing.Size(118, 25);
            this.LMisses.TabIndex = 7;
            this.LMisses.Text = "Промахи: 0";
            // 
            // LHits
            // 
            this.LHits.AutoSize = true;
            this.LHits.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.LHits.Location = new System.Drawing.Point(7, 239);
            this.LHits.Name = "LHits";
            this.LHits.Size = new System.Drawing.Size(135, 25);
            this.LHits.TabIndex = 6;
            this.LHits.Text = "Попадания: 0";
            // 
            // LShot
            // 
            this.LShot.AutoSize = true;
            this.LShot.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.LShot.Location = new System.Drawing.Point(7, 198);
            this.LShot.Name = "LShot";
            this.LShot.Size = new System.Drawing.Size(130, 25);
            this.LShot.TabIndex = 1;
            this.LShot.Text = "Выстрелы: 0";
            // 
            // LaRadius
            // 
            this.LaRadius.AutoSize = true;
            this.LaRadius.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.LaRadius.Location = new System.Drawing.Point(6, 138);
            this.LaRadius.Name = "LaRadius";
            this.LaRadius.Size = new System.Drawing.Size(172, 50);
            this.LaRadius.TabIndex = 5;
            this.LaRadius.Text = "Текущий радиус: \r\n50";
            // 
            // BRadius
            // 
            this.BRadius.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(255)))), ((int)(((byte)(128)))));
            this.BRadius.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.BRadius.Location = new System.Drawing.Point(12, 88);
            this.BRadius.Name = "BRadius";
            this.BRadius.Size = new System.Drawing.Size(149, 34);
            this.BRadius.TabIndex = 0;
            this.BRadius.Text = "Применить";
            this.BRadius.UseVisualStyleBackColor = false;
            this.BRadius.Click += new System.EventHandler(this.BRadius_Click);
            // 
            // TRadius
            // 
            this.TRadius.Location = new System.Drawing.Point(11, 60);
            this.TRadius.Name = "TRadius";
            this.TRadius.Size = new System.Drawing.Size(150, 22);
            this.TRadius.TabIndex = 1;
            // 
            // LRadius
            // 
            this.LRadius.AutoSize = true;
            this.LRadius.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.LRadius.Location = new System.Drawing.Point(6, 18);
            this.LRadius.Name = "LRadius";
            this.LRadius.Size = new System.Drawing.Size(164, 25);
            this.LRadius.TabIndex = 4;
            this.LRadius.Text = "Радиус мишени:";
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
            this.MouseClick += new System.Windows.Forms.MouseEventHandler(this.Form1_MouseClick);
            this.Menu.ResumeLayout(false);
            this.Menu.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox Menu;
        private System.Windows.Forms.Label LMisses;
        private System.Windows.Forms.Label LHits;
        private System.Windows.Forms.Label LShot;
        private System.Windows.Forms.Label LaRadius;
        private System.Windows.Forms.Button BRadius;
        private System.Windows.Forms.TextBox TRadius;
        private System.Windows.Forms.Label LRadius;
        private System.Windows.Forms.Label LY;
        private System.Windows.Forms.Label LX;
        private System.Windows.Forms.Button BShot;
        private System.Windows.Forms.TextBox TY;
        private System.Windows.Forms.TextBox TX;
    }
}

