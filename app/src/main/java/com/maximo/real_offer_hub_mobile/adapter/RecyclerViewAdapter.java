package com.maximo.real_offer_hub_mobile.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.datastore.generated.model.Offer;
import com.maximo.real_offer_hub_mobile.R;
import com.maximo.real_offer_hub_mobile.activities.DashboardActivity;
import com.maximo.real_offer_hub_mobile.activities.OfferDetailActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemVH> {
    private static final String TAG ="RecyclerViewAdapter";
    List<Offer> offerList;
    Context callingActivity;
//    boolean[] state;

    public static final String OFFER_PRICE_TAG = "OfferPriceTag";
    public static final String PROPERTY_VIEW_TAG = "PropertyTag";
    public static final String EARNEST_MONEY_TAG = "EarnestMoneyTag";
    public static final String LOAN_TYPE_TAG = "LoanTypeTag";
    public static final String BUYERS_AGENT_TAG = "BuyersAgentTag";
    public static final String RESPONSE_DATE_TAG = "ResponseDateTag";
    public static final String RESPONSE_TIME_TAG = "ResponseTimeTag";
    public static final String CLOSE_OF_ESCROW_TAG = "CloseOfEscrowTag";

    public RecyclerViewAdapter(List<Offer> offerList, Context callingActivity) {
        this.offerList = offerList;
        this.callingActivity = callingActivity;
//        this.state = new boolean[offerList.size()];
    }

    @NonNull
    @Override
    public ItemVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View offerFragment = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ItemVH(offerFragment);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemVH holder, int position) {

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM dd, yyyy");
//        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
//        String temporalDateTime = simpleDateFormat.format(offerList.get(position).getResponseDate());

        Offer offer = offerList.get(position);

        TextView offerPriceTV = holder.itemView.findViewById(R.id.item_layoutTextViewOfferPriceValue);
        offerPriceTV.setText(offer.getOfferPrice().toString());

        TextView propertyTV = holder.itemView.findViewById(R.id.item_layoutTextViewProperty);
        propertyTV.setText(offer.getProperty().getAddress());

        TextView earnestMoneyTV = holder.itemView.findViewById(R.id.item_layoutTextViewEarnestMoneyValue);
        earnestMoneyTV.setText(offer.getErnestMoneyAmountString());

        TextView loanTypeTV = holder.itemView.findViewById(R.id.item_layoutTextViewLoanTypeValue);
        loanTypeTV.setText(offer.getLoanType());

        TextView buyersAgentTV = holder.itemView.findViewById(R.id.item_layoutTextViewBuyersAgentValue);
        buyersAgentTV.setText(offer.getBuyersFirstName());

        TextView responseDateTV = holder.itemView.findViewById(R.id.item_layoutTextViewResponseDateValue);
        responseDateTV.setText(offer.getResponseDateString());

        TextView responseTimeTV = holder.itemView.findViewById(R.id.item_layoutTextViewResponseTimeValue);
        responseTimeTV.setText(offer.getResponseTimeString());

        TextView closeOfEscrowTV = holder.itemView.findViewById(R.id.item_layoutTextViewCloseOfEscrowValue);
        closeOfEscrowTV.setText(offer.getCloseOfEscrowString());

//        boolean isExpanded = this.state[position];
//        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE:View.GONE);

        View offerListItemView = holder.itemView;
        offerListItemView.setOnClickListener(view -> {
            Intent goToOfferDetailIntent = new Intent(callingActivity, OfferDetailActivity.class);
            goToOfferDetailIntent.putExtra(OFFER_PRICE_TAG, offer.getOfferPrice());
            goToOfferDetailIntent.putExtra(OFFER_PRICE_TAG, offer.getOfferPrice());
            goToOfferDetailIntent.putExtra(PROPERTY_VIEW_TAG, offer.getProperty().getAddress());
            goToOfferDetailIntent.putExtra(EARNEST_MONEY_TAG, offer.getErnestMoneyAmountString());
            goToOfferDetailIntent.putExtra(LOAN_TYPE_TAG, offer.getLoanType());
            goToOfferDetailIntent.putExtra(BUYERS_AGENT_TAG, offer.getBuyersFirstName() + " " + offer.getBuyersLastName());
            goToOfferDetailIntent.putExtra(RESPONSE_DATE_TAG, offer.getResponseDateString());
            goToOfferDetailIntent.putExtra(RESPONSE_TIME_TAG, offer.getResponseTimeString());
            goToOfferDetailIntent.putExtra(CLOSE_OF_ESCROW_TAG, offer.getCloseOfEscrowString());

            callingActivity.startActivity(goToOfferDetailIntent);
        });


//        holder.offerPriceView.setText(offer.getOfferPrice().toString());
//        holder.propertyView.setText(offer.getProperty().toString());
//        holder.earnestMoneyView.setText(offer.getErnestMoneyAmountString());
//        holder.loanTypeView.setText(offer.getLoanType());
//        holder.buyersAgentView.setText(offer.getBuyersFirstName() + " " + offer.getBuyersLastName());
//        holder.responseDateView.setText(temporalDateTime);
//        holder.responseTimeView.setText(offer.getResponseTimeString());
//        holder.closeOfEscrowView.setText(offer.getCloseOfEscrowString());
//        boolean isExpanded = this.state[position];
//        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE:View.GONE);
//
//        View offerListItemView = holder.itemView;
//        offerListItemView.setOnClickListener(view -> {
//            Intent goToOfferDetailIntent = new Intent(callingActivity, OfferDetailActivity.class);
//            goToOfferDetailIntent.putExtra(OFFER_PRICE_TAG, offer.getOfferPrice());
//            goToOfferDetailIntent.putExtra(PROPERTY_VIEW_TAG, offer.getProperty().toString());
//            goToOfferDetailIntent.putExtra(EARNEST_MONEY_TAG, offer.getErnestMoneyAmountString());
//            goToOfferDetailIntent.putExtra(LOAN_TYPE_TAG, offer.getLoanType());
//            goToOfferDetailIntent.putExtra(BUYERS_AGENT_TAG, offer.getBuyersFirstName() + " " + offer.getBuyersLastName());
//            goToOfferDetailIntent.putExtra(RESPONSE_DATE_TAG, offer.getResponseDateString());
//            goToOfferDetailIntent.putExtra(RESPONSE_TIME_TAG, offer.getResponseTimeString());
//            goToOfferDetailIntent.putExtra(CLOSE_OF_ESCROW_TAG, offer.getCloseOfEscrowString());
//
//            callingActivity.startActivity(goToOfferDetailIntent);
//        });

    }

    @Override
    public int getItemCount() {
        return offerList.size();
    }

    public void updateOfferListData(List<Offer> updatedOfferList) {
        int offerListSize = offerList.size();
        offerList = updatedOfferList;
        while (offerListSize < updatedOfferList.size())
            this.notifyItemInserted(offerListSize++);
    }

    class ItemVH extends RecyclerView.ViewHolder {
        public static final String TAG = "Item";

//        TextView propertyView;

//        TextView offerPriceView, propertyView, earnestMoneyView, loanTypeView, buyersAgentView, responseDateView, responseTimeView, closeOfEscrowView;
//        Button offerDetailsButton = itemView.findViewById(R.id.item_layoutBtnSeeMoreOfferDetails);
//        ConstraintLayout expandableLayout;
        public ItemVH(@NonNull View itemView){
            super(itemView);
//            offerPriceView = itemView.findViewById(R.id.item_layoutTextViewOfferPriceValue);
//            propertyView = itemView.findViewById(R.id.item_layoutTextViewProperty);
//            earnestMoneyView = itemView.findViewById(R.id.item_layoutTextViewEarnestMoneyValue);
//            loanTypeView = itemView.findViewById(R.id.item_layoutTextViewLoanTypeValue);
//            buyersAgentView = itemView.findViewById(R.id.item_layoutTextViewBuyersAgentValue);
//            responseDateView = itemView.findViewById(R.id.item_layoutTextViewResponseDateValue);
//            responseTimeView = itemView.findViewById(R.id.item_layoutTextViewResponseTimeValue);
//            closeOfEscrowView = itemView.findViewById(R.id.item_layoutTextViewCloseOfEscrowValue);


//            propertyView = itemView.findViewById(R.id.item_layoutTextViewProperty);
//            expandableLayout = itemView.findViewById(R.id.expandablelayout);
//
//
//
//            propertyView.setOnClickListener(view -> {
//                state[getAdapterPosition()] = !state[getAdapterPosition()];
//                notifyItemChanged(getAdapterPosition());
//            });

        }
    }
}
