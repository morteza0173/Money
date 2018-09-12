package com.takart.money.money;

import android.animation.ValueAnimator;
import android.renderscript.Sampler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DashbordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord);
        final int[] addMoneyMath = {0};


        final boolean[] addmoney1 = {true};
        final boolean[] losemoney1 = {true};

        final float scale = getBaseContext().getResources().getDisplayMetrics().density;
        final int pixels = (int) (65 * scale + 0.5f);
        final int pixels1 = (int) (27 * scale + 0.5f);
        final int pixels2 = (int) (95 * scale + 0.5f);



        final CardView cardViewCenter = (CardView)findViewById(R.id.cardView4);
        final Button addMoneyButton = (Button)findViewById(R.id.button2);
        final Animation anim1 =AnimationUtils.loadAnimation(DashbordActivity.this,R.anim.cardview4);
        final Button loseMoney = (Button)findViewById(R.id.button);
        final EditText edttextAddMoney = (EditText)findViewById(R.id.editTextAddMoney);
        final TextView txtViewAddMoney = (TextView)findViewById(R.id.textView3_addMoney);
        final EditText edttextloseMoney = (EditText)findViewById(R.id.editTextLoseMoney);
        final TextView txtViewloseMoney = (TextView)findViewById(R.id.textViewLoseMoney);
        final TextView txtViewAllMoneyYouHave = (TextView)findViewById(R.id.textView_allMoneyYouHave);

        addMoneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(addmoney1[0]) {
                    if(losemoney1[0]){
                        Animation animation = new TranslateAnimation(0, 0, pixels1, 0);
                        animation.setDuration(200);
                        cardViewCenter.setAnimation(animation);
                        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) cardViewCenter.getLayoutParams();
                        params.topMargin = pixels;
                        cardViewCenter.setLayoutParams(params);
                        addmoney1[0] =false;
                        addMoneyButton.setText("ذخیره درآمد");
                        edttextAddMoney.setVisibility(View.VISIBLE);
                        txtViewAddMoney.setVisibility(View.VISIBLE);
                        edttextAddMoney.setText("");

                    }

                }else {
                    Animation animation = new TranslateAnimation(0, 0, -pixels1, 0);
                    animation.setDuration(200);
                    cardViewCenter.setAnimation(animation);
                    ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) cardViewCenter.getLayoutParams();
                    params.topMargin = pixels2;
                    cardViewCenter.setLayoutParams(params);
                    addmoney1[0] =true;
                    addMoneyButton.setText("افزودن درآمد");
                    edttextAddMoney.setVisibility(View.GONE);
                    txtViewAddMoney.setVisibility(View.GONE);
                    int moneyYouHave = Integer.valueOf(txtViewAllMoneyYouHave.getText().toString());
                    addMoneyMath[0] += Integer.valueOf(edttextAddMoney.getText().toString());
                    ValueAnimator allMoneyYouHaveAnimation = ValueAnimator.ofInt(moneyYouHave , addMoneyMath[0]);
                    allMoneyYouHaveAnimation.setDuration(200);
                    allMoneyYouHaveAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            txtViewAllMoneyYouHave.setText(valueAnimator.getAnimatedValue().toString());
                        }
                    });allMoneyYouHaveAnimation.start();





                }
            }
        });


        loseMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (losemoney1[0]){
                    if(addmoney1[0]){
                        Animation animation = new TranslateAnimation(0, 0, pixels1, 0);
                        animation.setDuration(200);
                        cardViewCenter.setAnimation(animation);
                        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) cardViewCenter.getLayoutParams();
                        params.topMargin = pixels;
                        cardViewCenter.setLayoutParams(params);
                        losemoney1[0] =false;
                        loseMoney.setText("ذخیره خرج");
                        edttextloseMoney.setVisibility(View.VISIBLE);
                        txtViewloseMoney.setVisibility(View.VISIBLE);
                    }
                    }else {
                    Animation animation = new TranslateAnimation(0, 0, -pixels1, 0);
                    animation.setDuration(200);
                    cardViewCenter.setAnimation(animation);
                    ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) cardViewCenter.getLayoutParams();
                    params.topMargin = pixels2;
                    cardViewCenter.setLayoutParams(params);
                    losemoney1[0] =true;
                    loseMoney.setText("افزودن خرج");
                    edttextloseMoney.setVisibility(View.GONE);
                    txtViewloseMoney.setVisibility(View.GONE);
                }

            }
        });


    }
}
