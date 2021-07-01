package com.example.healthright.shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.healthright.R;

import java.util.ArrayList;

public class Shop extends AppCompatActivity {
    RecyclerView recyclerView;
    shop_adapter shop_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_shop);


        recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewS);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        shop_adapter = new shop_adapter(data(), this);
        recyclerView.setAdapter(shop_adapter);

        /*ImageView img = (ImageView) findViewById(R.id.product_img);
        img.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.myprotein.co.in/sports-nutrition/impact-whey-protein/11654605.html"));
                startActivity(intent);*/

    }

    public ArrayList<shop_model> data() {
        ArrayList<shop_model> holder = new ArrayList<>();

        shop_model product1 = new shop_model();
        product1.setImg_name(R.drawable.myprotien);
        product1.setWebsite("https://www.myprotein.co.in/sports-nutrition/impact-whey-protein/11654605.html");
        holder.add(product1);

        shop_model product2 = new shop_model();
        product2.setImg_name(R.drawable.yoga_mat);
        product2.setWebsite("https://www.amazon.in/Aradhya-Fab-Workout-Flooring-Exercise/dp/B08FRRNH6D/ref=asc_df_B08FRRNH6D/?tag=googleshopdes-21&linkCode=df0&hvadid=397010109307&hvpos=&hvnetw=g&hvrand=3545238964063802801&hvpone=&hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9061654&hvtargid=pla-942095173890&psc=1&ext_vrnc=hi");
        holder.add(product2);

        shop_model product3 = new shop_model();
        product3.setImg_name(R.drawable.organic_multivitamin);
        product3.setWebsite("https://www.thehimalayanorganics.in/products/himalayan-organics-whole-food-multivitamin-for-men-with-natural-vitamins-minerals-extracts-best-for-energy-brain-heart-health-eye-health-60-veg-capsules?variant=33658420134023&currency=INR&utm_medium=product_sync&utm_source=google&utm_content=sag_organic&utm_campaign=sag_organic&utm_campaign=gs-2020-05-21&utm_source=google&utm_medium=smart_campaign&gclid=Cj0KCQjw_dWGBhDAARIsAMcYuJyBDgYp7B4sI3P6jQJRJ7ajdJ7z7Q8ToCV-fIy8NV9dv8Y4ixi7Ad8aAlc5EALw_wcB");
        holder.add(product3);

        shop_model product4 = new shop_model();
        product4.setImg_name(R.drawable.immunity_booster);
        product4.setWebsite("https://roncuvita.com/products/immunity-booster-800-mg-with-herbal-formulation-for-immune-system-support?currency=INR&variant=39443661095068&utm_medium=cpc&utm_source=google&utm_campaign=Google%20Shopping&gclid=Cj0KCQjw_dWGBhDAARIsAMcYuJx3VigGyGLSpOZ1zv0AsMQLgsRxFTwS6rbGRBeFi4ZCjrXkMBoGdAoaAslBEALw_wcB");
        holder.add(product4);

        shop_model product5 = new shop_model();
        product5.setImg_name(R.drawable.chyawnprash);
        product5.setWebsite("https://www.kapiva.in/product/kapiva-chyawanprash/?utm_campaignname={campaignname}&utm_source=google&utm_medium=cpc&utm_content=405629849916&utm_term=&adgroupid=88154369962&gclid=Cj0KCQjw_dWGBhDAARIsAMcYuJzz9GyLdD-r_tNjruBS-C1Iw5HkurzcjxOazxPjdjoRbz1e3yigq7saAun1EALw_wcB");
        holder.add(product5);

        shop_model product6 = new shop_model();
        product6.setImg_name(R.drawable.protinex);
        product6.setWebsite("https://www.amazon.in/Protinex-Original-400-g/dp/B019391JCQ/ref=asc_df_B019391JCQ/?tag=googleshopdes-21&linkCode=df0&hvadid=397081348724&hvpos=&hvnetw=g&hvrand=8809844552559249416&hvpone=&hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9061654&hvtargid=pla-412172059167&psc=1&ext_vrnc=hi");
        holder.add(product6);

        return holder;
    }
}