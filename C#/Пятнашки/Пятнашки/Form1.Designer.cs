namespace Пятнашки
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
            this.components = new System.ComponentModel.Container();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle1 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle2 = new System.Windows.Forms.DataGridViewCellStyle();
            this.MatrixGame = new System.Windows.Forms.DataGridView();
            this.Bnewgema = new System.Windows.Forms.Button();
            this.Bsavedgame = new System.Windows.Forms.Button();
            this.Lstep = new System.Windows.Forms.Label();
            this.Ltime = new System.Windows.Forms.Label();
            this.TimerGame = new System.Windows.Forms.Timer(this.components);
            ((System.ComponentModel.ISupportInitialize)(this.MatrixGame)).BeginInit();
            this.SuspendLayout();
            // 
            // MatrixGame
            // 
            this.MatrixGame.AllowUserToAddRows = false;
            this.MatrixGame.AllowUserToDeleteRows = false;
            this.MatrixGame.AllowUserToResizeColumns = false;
            this.MatrixGame.AllowUserToResizeRows = false;
            this.MatrixGame.BackgroundColor = System.Drawing.Color.Yellow;
            this.MatrixGame.CausesValidation = false;
            this.MatrixGame.CellBorderStyle = System.Windows.Forms.DataGridViewCellBorderStyle.Sunken;
            this.MatrixGame.ColumnHeadersBorderStyle = System.Windows.Forms.DataGridViewHeaderBorderStyle.Sunken;
            dataGridViewCellStyle1.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            dataGridViewCellStyle1.BackColor = System.Drawing.SystemColors.Control;
            dataGridViewCellStyle1.Font = new System.Drawing.Font("Microsoft Sans Serif", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            dataGridViewCellStyle1.ForeColor = System.Drawing.SystemColors.WindowText;
            dataGridViewCellStyle1.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle1.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle1.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.MatrixGame.ColumnHeadersDefaultCellStyle = dataGridViewCellStyle1;
            this.MatrixGame.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.MatrixGame.ColumnHeadersVisible = false;
            dataGridViewCellStyle2.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            dataGridViewCellStyle2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            dataGridViewCellStyle2.Font = new System.Drawing.Font("Microsoft Sans Serif", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            dataGridViewCellStyle2.ForeColor = System.Drawing.Color.Yellow;
            dataGridViewCellStyle2.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle2.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle2.WrapMode = System.Windows.Forms.DataGridViewTriState.False;
            this.MatrixGame.DefaultCellStyle = dataGridViewCellStyle2;
            this.MatrixGame.EnableHeadersVisualStyles = false;
            this.MatrixGame.Location = new System.Drawing.Point(12, 12);
            this.MatrixGame.MultiSelect = false;
            this.MatrixGame.Name = "MatrixGame";
            this.MatrixGame.ReadOnly = true;
            this.MatrixGame.RowHeadersBorderStyle = System.Windows.Forms.DataGridViewHeaderBorderStyle.Sunken;
            this.MatrixGame.RowHeadersVisible = false;
            this.MatrixGame.RowHeadersWidth = 51;
            this.MatrixGame.RowTemplate.Height = 24;
            this.MatrixGame.ShowCellErrors = false;
            this.MatrixGame.ShowCellToolTips = false;
            this.MatrixGame.ShowEditingIcon = false;
            this.MatrixGame.ShowRowErrors = false;
            this.MatrixGame.Size = new System.Drawing.Size(370, 352);
            this.MatrixGame.TabIndex = 0;
            this.MatrixGame.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.MatrixGame_CellClick);
            // 
            // Bnewgema
            // 
            this.Bnewgema.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.Bnewgema.Font = new System.Drawing.Font("Microsoft Sans Serif", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.Bnewgema.Location = new System.Drawing.Point(506, 12);
            this.Bnewgema.Name = "Bnewgema";
            this.Bnewgema.Size = new System.Drawing.Size(170, 129);
            this.Bnewgema.TabIndex = 1;
            this.Bnewgema.Text = "Новая игра";
            this.Bnewgema.UseVisualStyleBackColor = false;
            this.Bnewgema.Click += new System.EventHandler(this.Bnewgema_Click);
            // 
            // Bsavedgame
            // 
            this.Bsavedgame.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.Bsavedgame.Font = new System.Drawing.Font("Microsoft Sans Serif", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.Bsavedgame.Location = new System.Drawing.Point(506, 160);
            this.Bsavedgame.Name = "Bsavedgame";
            this.Bsavedgame.Size = new System.Drawing.Size(170, 129);
            this.Bsavedgame.TabIndex = 2;
            this.Bsavedgame.Text = "Переиграть";
            this.Bsavedgame.UseVisualStyleBackColor = false;
            this.Bsavedgame.Click += new System.EventHandler(this.Bsavedgame_Click);
            // 
            // Lstep
            // 
            this.Lstep.AutoSize = true;
            this.Lstep.BackColor = System.Drawing.Color.Red;
            this.Lstep.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.Lstep.Location = new System.Drawing.Point(202, 381);
            this.Lstep.Name = "Lstep";
            this.Lstep.Size = new System.Drawing.Size(185, 20);
            this.Lstep.TabIndex = 3;
            this.Lstep.Text = "Количество шагов: 0";
            // 
            // Ltime
            // 
            this.Ltime.AutoSize = true;
            this.Ltime.BackColor = System.Drawing.Color.Red;
            this.Ltime.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.Ltime.Location = new System.Drawing.Point(23, 381);
            this.Ltime.Name = "Ltime";
            this.Ltime.Size = new System.Drawing.Size(123, 20);
            this.Ltime.TabIndex = 4;
            this.Ltime.Text = "Таймер: 0 сек";
            // 
            // TimerGame
            // 
            this.TimerGame.Interval = 1000;
            this.TimerGame.Tick += new System.EventHandler(this.TimerGame_Tick);
            // 
            // GameForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Fuchsia;
            this.ClientSize = new System.Drawing.Size(694, 450);
            this.Controls.Add(this.Ltime);
            this.Controls.Add(this.Lstep);
            this.Controls.Add(this.Bsavedgame);
            this.Controls.Add(this.Bnewgema);
            this.Controls.Add(this.MatrixGame);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.MaximizeBox = false;
            this.Name = "GameForm";
            this.Text = "Пятнашки";
            this.Load += new System.EventHandler(this.GameForm_Load);
            ((System.ComponentModel.ISupportInitialize)(this.MatrixGame)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView MatrixGame;
        private System.Windows.Forms.Button Bnewgema;
        private System.Windows.Forms.Button Bsavedgame;
        private System.Windows.Forms.Label Lstep;
        private System.Windows.Forms.Label Ltime;
        private System.Windows.Forms.Timer TimerGame;
    }
}

