package com.gurjeet.tourismapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Spinner country;
    ImageView flag;
    TextView capital, totalPrice;
    ListView countryList;
    Button calculate;
    EditText numberVisitors;

    String countries[]={"Canada","India","Rome"};
    ArrayList<Country>allCountryList=new ArrayList<>();
    ArrayList<CountryLocation>locationsList=new ArrayList<>();
    public static ArrayList<CountryLocation>tempLocations=new ArrayList<>();
    public static double selectedPrice=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        country=findViewById(R.id.spCountry);
        flag=findViewById(R.id.imvCountryFlag);
        capital=findViewById(R.id.txvCapital);
        totalPrice=findViewById(R.id.txvTotalAmount);
        calculate=findViewById(R.id.btnCalculate);
        numberVisitors=findViewById(R.id.extNoOfVisitors);
        countryList=findViewById(R.id.lvLocations);

        fillLocations();

        //filling the spinner with country name by creating an array adapter of country
        ArrayAdapter aa=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,countries);
        country.setAdapter(aa);




        // on selection of country show tourist locations in below listview
        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                capital.setText(allCountryList.get(position).getCountryCapital());
                flag.setImageResource(allCountryList.get(position).getCountryFlag());
                ArrayList obj=getTouristLocations(countries[position]);
                countryList.setAdapter(new CountryAdapter(MainActivity.this,tempLocations));

                //to select the first location/item under any country as default selected at first
                int defaultPositon = 0;
                countryList.setItemChecked(defaultPositon, true);
                countryList.performItemClick(countryList.getSelectedView(), defaultPositon, 0);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //location select from listview
        countryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPrice=tempLocations.get(position).getLocationPrice();

                // setting the background color of selected items
                for(int i=0; i<parent.getChildCount(); i++)
                {
                    if(i == position)
                        parent.getChildAt(i).setBackgroundColor(Color.parseColor("#4D2257F6"));
                    else
                        parent.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                }

            }
        });


        //method to calculate the cost based on no. of visitors & discount 5% if more than 15
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numberVisitors.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter number of visitors", Toast.LENGTH_SHORT).show();
                    return;
                }
                double finalPrice = 0;
                double price = selectedPrice;
                int visitors =  Integer.parseInt(numberVisitors.getText().toString());
                if (visitors > 15)
                    finalPrice = visitors * (price - (price * 0.05));
                else
                    finalPrice = visitors * price;
                totalPrice.setText("$ " + finalPrice);
            }
        });

    }



    //method receives country and returns temporary array of location names
    public ArrayList getTouristLocations(String countryName){
        tempLocations.clear();
        for(CountryLocation cln:locationsList)
            if(cln.getCountryName().equalsIgnoreCase(countryName))
                tempLocations.add(cln);
        System.out.println(tempLocations);
        return tempLocations;
    }


    //method to fll data or  both country and locations classes
    public void fillLocations(){
        allCountryList.add(new Country(countries[0],"Ottawa",R.drawable.canada));
        allCountryList.add(new Country(countries[1],"New Delhi",R.drawable.india));
        allCountryList.add(new Country(countries[2],"Italy",R.drawable.italy));

        locationsList.add(new CountryLocation(countries[0],"Niagara Falls",R.drawable.niagara_falls,1000));
        locationsList.add(new CountryLocation(countries[0],"Old Quebec",R.drawable.old_quebec,1100));
        locationsList.add(new CountryLocation(countries[0],"Stanley Park",R.drawable.vancouver_stanley_park,1200));

        locationsList.add(new CountryLocation(countries[1],"Golden Temple",R.drawable.golden_temple,100));
        locationsList.add(new CountryLocation(countries[1],"Taj Mahal",R.drawable.taj_mahal,200));
        locationsList.add(new CountryLocation(countries[1],"Victoria Memorial",R.drawable.victoria_memorial,300));

        locationsList.add(new CountryLocation(countries[2],"Piazza Navona",R.drawable.piazza_navona,2000));
        locationsList.add(new CountryLocation(countries[2],"Vatican City",R.drawable.vatican_city,2200));
        locationsList.add(new CountryLocation(countries[2],"Palatine Hill",R.drawable.palatine_hill,2300));

    }



}