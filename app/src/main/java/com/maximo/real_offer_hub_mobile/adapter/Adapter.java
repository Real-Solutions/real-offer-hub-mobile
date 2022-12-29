package com.maximo.real_offer_hub_mobile.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.maximo.real_offer_hub_mobile.R;
import com.maximo.real_offer_hub_mobile.activities.ModelB;


import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ItemVH> {
    private static final String TAG ="Adapter";
    List<ModelB> modelList;
    boolean[] state;

    public Adapter(List<ModelB> modelList) {
        this.modelList = modelList;
        this.state = new boolean[modelList.size()];
    }

    @Override
    public Adapter.ItemVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ItemVH(view);
    }

    @Override
    public void onBindViewHolder(Adapter.ItemVH holder, int position) {

        ModelB modelB = modelList.get(position);
        holder.propertyView.setText(modelB.getProperty());
        holder.earnestMoneyView.setText(modelB.getEarnestMoney());
        holder.loanTypeView.setText(modelB.getLoanType());
        holder.buyersAgentView.setText(modelB.getBuyersAgent());
        holder.responseDateView.setText(modelB.getResponseDate());
        holder.responseTimeView.setText(modelB.getResponseTime());
        holder.closeOfEscrowView.setText(modelB.getCloseOfEscrow());
        boolean isExpanded = this.state[position];
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE:View.GONE);



    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    class ItemVH extends RecyclerView.ViewHolder{
        private static final String TAG = "Item";
        TextView propertyView, earnestMoneyView, loanTypeView, buyersAgentView, responseDateView, responseTimeView, closeOfEscrowView;
        ConstraintLayout expandableLayout;
        public ItemVH(View itemView) {
            super(itemView);
            propertyView = itemView.findViewById(R.id.item_layoutTextViewProperty);
            earnestMoneyView = itemView.findViewById(R.id.item_layoutTextViewEarnestMoneyValue);
            loanTypeView = itemView.findViewById(R.id.item_layoutTextViewLoanTypeValue);
            buyersAgentView = itemView.findViewById(R.id.item_layoutTextViewBuyersAgentValue);
            responseDateView = itemView.findViewById(R.id.item_layoutTextViewResponseDateValue);
            responseTimeView = itemView.findViewById(R.id.item_layoutTextViewResponseTimeValue);
            closeOfEscrowView = itemView.findViewById(R.id.item_layoutTextViewCloseOfEscrowValue);
            expandableLayout = itemView.findViewById(R.id.expandablelayout);

            propertyView.setOnClickListener(view -> {
                state[getAdapterPosition()] = !state[getAdapterPosition()];
                notifyItemChanged(getAdapterPosition());
            });
        }
    }
}
