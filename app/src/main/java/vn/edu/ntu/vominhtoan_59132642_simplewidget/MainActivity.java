package vn.edu.ntu.vominhtoan_59132642_simplewidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtSoThich,edtNgaySinh, edtTen;
    RadioGroup rdgGioiTinh;
    Button btnXacNhan;
    CheckBox cb1,cb2,cb3,cb4,cb5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
        addEvents();
    }

    private void addView()
    {
        edtNgaySinh =findViewById(R.id.edtNgaySinh);
        edtSoThich = findViewById(R.id.edtSoThich);
        edtTen = findViewById(R.id.edtTen);
        rdgGioiTinh = findViewById(R.id.rdgGioiTinh);
        btnXacNhan = findViewById(R.id.btnXacNhan);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb4);
        cb5 = findViewById(R.id.cb5);
    }

    private void addEvents()
    {
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thongBao();
            }
        });
    }

    private void thongBao()
    {
        //Hiển thị tên & ngày sinh
        String tinNhan="";
        String gioiTinh ="";
        String soThich="";
        CheckBox[] cb = new CheckBox[]{cb1, cb2, cb3, cb4, cb5};
        for (int i = 0; i < cb.length; i++)
        {
            if (cb[i].isChecked())
            {
                soThich = soThich + cb[i].getText().toString() + "; ";
            }
        }

        //Hiển thị giới tính
        switch (rdgGioiTinh.getCheckedRadioButtonId())
        {
            //Nếu click vào rb Nam
            case R.id.rdbNam:
                gioiTinh = "Nam";break;
            //Nếu clik vào rb Nữ
            case R.id.rdbNu:
                gioiTinh = "Nữ";break;
        }

        //Hiển thị sở thích
        tinNhan = "Tên của bạn: " + edtTen.getText() + "\n" +
                "Ngày Sinh: " + edtNgaySinh.getText() + "\n" +
                "Giới tính: " + gioiTinh + "\n" +
                "Sở thích: " + soThich  + edtSoThich.getText();
        Toast.makeText(MainActivity.this, tinNhan, Toast.LENGTH_SHORT).show();
    }

}
