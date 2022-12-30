package com.maximo.real_offer_hub_mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.maximo.real_offer_hub_mobile.R;
import com.maximo.real_offer_hub_mobile.adapter.RecyclerViewAdapter;
import com.maximo.real_offer_hub_mobile.databinding.ActivityOfferDetailBinding;

public class OfferDetailActivity extends DrawerBaseActivity {

    ActivityOfferDetailBinding activityOfferDetailBinding;

    public static final String TAG = "OfferDetailActivity";
    Intent callingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOfferDetailBinding = ActivityOfferDetailBinding.inflate(getLayoutInflater());
        setContentView(activityOfferDetailBinding.getRoot());
        allocateActivityTitle("Offer Details");

        receiveSetupOfferListValues();
    }

    @Override
    protected void onResume() {
        super.onResume();
        callingIntent = getIntent();
    }

    public void receiveSetupOfferListValues(){
        Intent callingIntent = getIntent();

        String offerPrice = null;
        if (callingIntent != null) {
            offerPrice = callingIntent.getStringExtra(RecyclerViewAdapter.OFFER_PRICE_TAG);
        }
        TextView offerPriceTV = findViewById(R.id.OfferDetailTextViewOfferPrice);
        if (offerPrice != null) {
            offerPriceTV.setText(offerPrice);
        } else {
            offerPriceTV.setText("No Value");
        }


        String earnestMoney = null;
        if (callingIntent != null) {
            earnestMoney = callingIntent.getStringExtra(RecyclerViewAdapter.EARNEST_MONEY_TAG);
        }
        TextView earnestMoneyTV = findViewById(R.id.OfferDetailTextViewEarnestMoneyValue);
        if (earnestMoney != null) {
            earnestMoneyTV.setText(earnestMoney);
        } else {
            earnestMoneyTV.setText("No Value");
        }


        String property = null;
        if (callingIntent != null) {
            property = callingIntent.getStringExtra(RecyclerViewAdapter.PROPERTY_VIEW_TAG);
        }
        TextView propertyTV = findViewById(R.id.OfferDetailTextViewProperty);
        if (property != null) {
            propertyTV.setText(property);
        } else {
            propertyTV.setText("No Value");
        }


        String loanType = null;
        if (callingIntent != null) {
            loanType = callingIntent.getStringExtra(RecyclerViewAdapter.LOAN_TYPE_TAG);
        }
        TextView loanTypeTV = findViewById(R.id.OfferDetailTextViewLoanTypeValue);
        if (loanType != null) {
            loanTypeTV.setText(loanType);
        } else {
            loanTypeTV.setText("No Value");
        }


        String buyersAgent = null;
        if (callingIntent != null) {
            buyersAgent = callingIntent.getStringExtra(RecyclerViewAdapter.BUYERS_AGENT_TAG);
        }
        TextView buyersAgentTV = findViewById(R.id.OfferDetailTextViewBuyersAgentValue);
        if (buyersAgent != null) {
            buyersAgentTV.setText(buyersAgent);
        } else {
            buyersAgentTV.setText("No Value");
        }


        String responseDate = null;
        if (callingIntent != null) {
            responseDate = callingIntent.getStringExtra(RecyclerViewAdapter.RESPONSE_DATE_TAG);
        }
        TextView responseDateTV = findViewById(R.id.OfferDetailTextViewResponseDateValue);
        if (responseDate != null) {
            responseDateTV.setText(responseDate);
        } else {
            responseDateTV.setText("No Value");
        }


        String responseTime = null;
        if (callingIntent != null) {
            responseTime = callingIntent.getStringExtra(RecyclerViewAdapter.RESPONSE_TIME_TAG);
        }
        TextView responseTimeTV = findViewById(R.id.OfferDetailTextViewResponseTimeValue);
        if (responseTime != null) {
            responseTimeTV.setText(responseTime);
        } else {
            responseTimeTV.setText("No Value");
        }


        String closeOfEscrow = null;
        if (callingIntent != null) {
            closeOfEscrow = callingIntent.getStringExtra(RecyclerViewAdapter.CLOSE_OF_ESCROW_TAG);
        }
        TextView closeOfEscrowTV = findViewById(R.id.OfferDetailTextViewCloseOfEscrowValue);
        if (closeOfEscrow != null) {
            closeOfEscrowTV.setText(closeOfEscrow);
        } else {
            responseTimeTV.setText("No Value");
        }






    }
}