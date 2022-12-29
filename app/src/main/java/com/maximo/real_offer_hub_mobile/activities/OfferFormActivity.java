package com.maximo.real_offer_hub_mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.datastore.generated.model.Offer;
import com.amplifyframework.datastore.generated.model.Property;
import com.maximo.real_offer_hub_mobile.R;
import com.maximo.real_offer_hub_mobile.databinding.ActivityOfferFormBinding;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


public class OfferFormActivity extends DrawerBaseActivity {
    public final static String TAG = "AddOfferActivity";
    Spinner propertiesSpinner;
    CompletableFuture<List<Property>> propertiesFuture = new CompletableFuture<>();
    ActivityOfferFormBinding activityOfferFormBinding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOfferFormBinding = ActivityOfferFormBinding.inflate(getLayoutInflater());
        setContentView(activityOfferFormBinding.getRoot());
        allocateActivityTitle("Submit Offer");
        propertiesSpinner = findViewById(R.id.OfferFormSpinnerPropertyAddress);

        Amplify.API.query(
                ModelQuery.list(Property.class),
                success -> {
                    Log.i(TAG, "Added Offers Successfully");
                    ArrayList<String> address = new ArrayList<>();
                    ArrayList<Property> properties = new ArrayList<>();
                    for (Property property: success.getData()) {
                        address.add(property.getAddress());
                        properties.add(property);
                    }
                    propertiesFuture.complete(properties);
                    runOnUiThread(() -> {
                        setupPropertySpinner(address);
                    });
                },
                failure -> {
                    propertiesFuture.complete(null);
                    Log.w(TAG, "Failed to read Teams from Database");
                }
        );

//        setupAddOfferButton();
    }

    public void setupPropertySpinner(ArrayList<String> address){
        propertiesSpinner.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                address
        ));
    }

//    public void setupAddOfferButton(){
//        Button addOfferButton = findViewById(R.id.OfferFormBtnSubmitOffer);
//        addOfferButton.setOnClickListener(view -> {
//            String selectedPropertyString = propertiesSpinner.getSelectedItem().toString();
//            List<Property> properties = null;
//            try{
//                properties = propertiesFuture.get();
//            } catch(InterruptedException ie){
//                Log.e(TAG, "InterruptedException while getting teams");
//                Thread.currentThread().interrupt();
//            } catch(ExecutionException ee) {
//                Log.e(TAG, "ExecutionException while getting teams");
//            }
//            Property selectedProperty = properties.stream().filter(theProperty -> theProperty.getAddress().equals(selectedPropertyString)).findAny().orElseThrow(RuntimeException::new);
//            Offer newOffer = Offer.builder()
//                .buyersFirstName(((EditText)findViewById(R.id.editTextTextPersonName2)).getText().toString())
//                .buyersLastName(((EditText)findViewById(R.id.OfferFormTextEditBuyersLastName)).getText().toString())
//                .offerPrice(Double.parseDouble(((EditText)findViewById(R.id.OfferFormNumberOfferPrice)).getText().toString()))
//                .ernestMoneyAmount(Double.parseDouble(((EditText)findViewById(R.id.offerFormNumberEarnestMoneyAmount)).getText().toString()))
//                .downPayment(Double.parseDouble(((EditText)findViewById(R.id.OfferFormNumberDownPayment)).getText().toString()))
//                .closeOfEscrow(new Temporal.Date(new Date(), 0))
//                .concessions(((EditText)findViewById(R.id.OfferFormTextEditConcessions)).getText().toString())
//                .loanType(((EditText)findViewById(R.id.OfferFormTextEditLoanType)).getText().toString())
//                .contingentBuyer(true)
//                .personalPropertyRequested(((EditText)findViewById(R.id.OfferFormTextEditPersonalPropertyRequested)).getText().toString())
//                .hoa(((EditText)findViewById(R.id.OfferFormTextEditHoa)).getText().toString())
//                .homeWarranty(((EditText)findViewById(R.id.OfferFormTextEditHomeWarranty)).getText().toString())
//                .inspectionPeriod(((EditText)findViewById(R.id.OfferFormTextEditInspectionPeriod)).getText().toString())
//                .escalation(true)
//                .responseDate(new Temporal.Date(new Date(), 0))
//                .responseTime(new Temporal.Time(new Date(), 0))
//                .additionalTermsAndConditions(((EditText)findViewById(R.id.OfferFormMultilineTextAdditionalTerms)).getText().toString())
//                .property(selectedProperty)
//                .build();
//
//
//            Amplify.API.mutate(
//                    ModelMutation.create(newOffer),
//                    success -> Log.i(TAG, "Made an offer successfully"),
//                    failure -> Log.i(TAG, "Failed to make an Offer", failure)
//            );
//
//            Toast.makeText(this, "Offer Saved!", Toast.LENGTH_SHORT).show();
//        });
//    }
}