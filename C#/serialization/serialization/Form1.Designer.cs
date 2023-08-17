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
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle3 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle4 = new System.Windows.Forms.DataGridViewCellStyle();
            this.MatrixGame = new System.Windows.Forms.DataGridView();
            this.Bnewgema = new System.Windows.Forms.Button();
            this.Bsavedgame = new System.Windows.Forms.Button();
            this.Lstep = new System.Windows.Forms.Label();
            this.Ltime = new System.Windows.Forms.Label();
            this.TimerGame = new System.Windows.Forms.Timer(this.components);
            this.B10recent_results = new System.Windows.Forms.Button();
            this.BBTop10players_steps = new System.Windows.Forms.Button();
            this.BTop10players_time = new System.Windows.Forms.Button();
            this.BDelete = new System.Windows.Forms.Button();
            this.DateTimePicker = new System.Windows.Forms.DateTimePicker();
            this.TName = new System.Windows.Forms.TextBox();
            this.LName = new System.Windows.Forms.Label();
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
            dataGridViewCellStyle3.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            dataGridViewCellStyle3.BackColor = System.Drawing.SystemColors.Control;
            dataGridViewCellStyle3.Font = new System.Drawing.Font("Microsoft Sans Serif", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            dataGridViewCellStyle3.ForeColor = System.Drawing.SystemColors.WindowText;
            dataGridViewCellStyle3.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle3.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle3.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.MatrixGame.ColumnHeadersDefaultCellStyle = dataGridViewCellStyle3;
            this.MatrixGame.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.MatrixGame.ColumnHeadersVisible = false;
            dataGridViewCellStyle4.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            dataGridViewCellStyle4.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            dataGridViewCellStyle4.Font = new System.Drawing.Font("Microsoft Sans Serif", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            dataGridViewCellStyle4.ForeColor = System.Drawing.Color.Yellow;
            dataGridViewCellStyle4.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle4.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle4.WrapMode = System.Windows.Forms.DataGridViewTriState.False;
            this.MatrixGame.DefaultCellStyle = dataGridViewCellStyle4;
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
            this.Bnewgema.Size = new System.Drawing.Size(170, 50);
            this.Bnewgema.TabIndex = 1;
            this.Bnewgema.Text = "Новая игра";
            this.Bnewgema.UseVisualStyleBackColor = false;
            this.Bnewgema.Click += new System.EventHandler(this.Bnewgema_Click);
            // 
            // Bsavedgame
            // 
            this.Bsavedgame.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.Bsavedgame.Font = new System.Drawing.Font("Microsoft Sans Serif", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.Bsavedgame.Location = new System.Drawing.Point(506, 68);
            this.Bsavedgame.Name = "Bsavedgame";
            this.Bsavedgame.Size = new System.Drawing.Size(170, 52);
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
            // B10recent_results
            // 
            this.B10recent_results.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.B10recent_results.Location = new System.Drawing.Point(506, 233);
            this.B10recent_results.Name = "B10recent_results";
            this.B10recent_results.Size = new System.Drawing.Size(170, 47);
            this.B10recent_results.TabIndex = 5;
            this.B10recent_results.Text = "10 последних результатов";
            this.B10recent_results.UseVisualStyleBackColor = false;
            this.B10recent_results.Click += new System.EventHandler(this.B10recent_results_Click);
            // 
            // BBTop10players_steps
            // 
            this.BBTop10players_steps.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.BBTop10players_steps.Location = new System.Drawing.Point(506, 181);
            this.BBTop10players_steps.Name = "BBTop10players_steps";
            this.BBTop10players_steps.Size = new System.Drawing.Size(170, 46);
            this.BBTop10players_steps.TabIndex = 6;
            this.BBTop10players_steps.Text = "10 лучших результатов по количеству ходов";
            this.BBTop10players_steps.UseVisualStyleBackColor = false;
            this.BBTop10players_steps.Click += new System.EventHandler(this.BBTop10players_steps_Click);
            // 
            // BTop10players_time
            // 
            this.BTop10players_time.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.BTop10players_time.Location = new System.Drawing.Point(506, 126);
            this.BTop10players_time.Name = "BTop10players_time";
            this.BTop10players_time.Size = new System.Drawing.Size(170, 49);
            this.BTop10players_time.TabIndex = 7;
            this.BTop10players_time.Text = "10 лучших результатов по времени";
            this.BTop10players_time.UseVisualStyleBackColor = false;
            this.BTop10players_time.Click += new System.EventHandler(this.BTop10players_time_Click);
            // 
            // BDelete
            // 
            this.BDelete.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.BDelete.Location = new System.Drawing.Point(506, 286);
            this.BDelete.Name = "BDelete";
            this.BDelete.Size = new System.Drawing.Size(170, 78);
            this.BDelete.TabIndex = 8;
            this.BDelete.Text = "удалить старые результаты (начиная с заданной даты)";
            this.BDelete.UseVisualStyleBackColor = false;
            this.BDelete.Click += new System.EventHandler(this.BDelete_Click);
            // 
            // DateTimePicker
            // 
            this.DateTimePicker.Location = new System.Drawing.Point(506, 370);
            this.DateTimePicker.Name = "DateTimePicker";
            this.DateTimePicker.Size = new System.Drawing.Size(170, 22);
            this.DateTimePicker.TabIndex = 9;
            // 
            // TName
            // 
            this.TName.Font = new System.Drawing.Font("Microsoft Sans Serif", 16.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.TName.Location = new System.Drawing.Point(506, 398);
            this.TName.Multiline = true;
            this.TName.Name = "TName";
            this.TName.Size = new System.Drawing.Size(170, 40);
            this.TName.TabIndex = 10;
            this.TName.Text = "Игрок";
            this.TName.TextChanged += new System.EventHandler(this.TName_TextChanged);
            // 
            // LName
            // 
            this.LName.AutoSize = true;
            this.LName.BackColor = System.Drawing.Color.Red;
            this.LName.Font = new System.Drawing.Font("Microsoft Sans Serif", 16.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.LName.Location = new System.Drawing.Point(430, 401);
            this.LName.Name = "LName";
            this.LName.Size = new System.Drawing.Size(70, 32);
            this.LName.TabIndex = 11;
            this.LName.Text = "Имя";
            // 
            // GameForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Fuchsia;
            this.ClientSize = new System.Drawing.Size(694, 450);
            this.Controls.Add(this.LName);
            this.Controls.Add(this.TName);
            this.Controls.Add(this.DateTimePicker);
            this.Controls.Add(this.BDelete);
            this.Controls.Add(this.BTop10players_time);
            this.Controls.Add(this.BBTop10players_steps);
            this.Controls.Add(this.B10recent_results);
            this.Controls.Add(this.Ltime);
            this.Controls.Add(this.Lstep);
            this.Controls.Add(this.Bsavedgame);
            this.Controls.Add(this.Bnewgema);
            this.Controls.Add(this.MatrixGame);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.MaximizeBox = false;
            this.Name = "GameForm";
            this.Text = "Пятнашки";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.GameForm_FormClosing);
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
        private System.Windows.Forms.Button B10recent_results;
        private System.Windows.Forms.Button BBTop10players_steps;
        private System.Windows.Forms.Button BTop10players_time;
        private System.Windows.Forms.Button BDelete;
        private System.Windows.Forms.DateTimePicker DateTimePicker;
        private System.Windows.Forms.TextBox TName;
        private System.Windows.Forms.Label LName;
    }
}

