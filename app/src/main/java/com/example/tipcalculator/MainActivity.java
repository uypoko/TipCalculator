package com.example.tipcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

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
    float billAmount = 0;
    final float FINE_TIP_PERCENT = 10;
    final float GOOD_TIP_PERCENT = 15;
    final float GREAT_TIP_PERCENT = 20;

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
                percentage = FINE_TIP_PERCENT;
                break;
            case R.id.ibGoodService:
                percentage = GOOD_TIP_PERCENT;
                break;
            case R.id.ibGreatService:
                percentage = GREAT_TIP_PERCENT;
                break;
        }
        calculateFinalBill();
        setTipValues();
    }

    @OnTextChanged(R.id.edBillAmount)
    public void onTextChange() {
        calculateFinalBill();
        setTipValues();
    }

    private void calculateFinalBill() {
        if (percentage == 0)
            percentage = FINE_TIP_PERCENT;
        if (!edBillAmount.getText().toString().equals(""))
            billAmount = Float.valueOf(edBillAmount.getText().toString());
        else
            billAmount = 0;
        tipTotal = billAmount*percentage/100;
        finalBillAmount = billAmount + tipTotal;
    }
}
