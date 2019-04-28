package com.example.tipcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edBillAmount)
    EditText edBillAmount;
    @BindView(R.id.tvTipPercent)
    TextView tvTipPercent;
    @BindView(R.id.tvTipAmount)
    TextView tvTipAmount;
    @BindView(R.id.tvBillTotalAmount)
    TextView tvBillTotalAmount;

    float percentage = 0;
    float tipTotal = 0;
    float finalBillAmount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setTipValues();
    }

    private void setTipValues() {
        tvTipPercent.setText(getString(R.string.main_msg_tippercent, percentage));
        tvTipAmount.setText(getString(R.string.main_msg_tiptotal, tipTotal));
        tvBillTotalAmount.setText(getString(R.string.main_msg_billtotal, finalBillAmount));
    }

    @OnClick({R.id.ibFineService, R.id.ibGoodService, R.id.ibGreatService})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ibFineService:
                break;
            case R.id.ibGoodService:
                break;
            case R.id.ibGreatService:
                break;
        }
    }
}
