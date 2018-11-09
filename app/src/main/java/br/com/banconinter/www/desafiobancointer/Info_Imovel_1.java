package br.com.banconinter.www.desafiobancointer;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.bumptech.glide.Glide;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Info_Imovel_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info__imovel_1);

        final Intent i = getIntent();

        // getSerializableExtra pega as infomações de acordo com o nome
        final String nome = (String) i.getSerializableExtra("nome");
        final String descricao = (String) i.getSerializableExtra("descricao");
        final String condominio = (String) i.getSerializableExtra("condominio");
        final String iptu = (String) i.getSerializableExtra("iptu");
        final String area = (String) i.getSerializableExtra("area");

        Objects.requireNonNull(getSupportActionBar()).setTitle(nome); // for set actionbar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for add back arrow in action bar

        TextView txtDesc = (TextView)findViewById(R.id.Descricao);
        txtDesc.setText(descricao);

        TextView txtCond = (TextView)findViewById(R.id.Condominio);
        txtCond.setText(condominio);

        TextView txtIptu = (TextView)findViewById(R.id.iptu);
        txtIptu.setText(iptu);

        TextView txtArea = (TextView)findViewById(R.id.area);
        txtArea.setText(area);

        ViewGroup.LayoutParams params = txtDesc.getLayoutParams();
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        txtDesc.setLayoutParams(params);
        txtCond.setLayoutParams(params);
        txtIptu.setLayoutParams(params);
        txtArea.setLayoutParams(params);

        final Button button = (Button) findViewById(R.id.btn_sim_fin);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Sim_Financiamento imv = new Sim_Financiamento();
                Intent itn = new Intent(Info_Imovel_1.this, Sim_Financiamento.class);
                Bundle b = i.getExtras();
                itn.putExtras(b);
                startActivity(itn);
            }
        });

        String seesh = (String)i.getSerializableExtra("images");
        List<String> stringList = new ArrayList<>(Arrays.asList(seesh.split("Δ")));

        CustomPagerAdapter mCustomPagerAdapter = new CustomPagerAdapter(this);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.ImageCar);
        mViewPager.setAdapter(mCustomPagerAdapter);
        LinearLayout LL_01 = findViewById(R.id.LL_01);
        for(int k = 0;k < stringList.size();k++){
            final ImageView iv = new ImageView(getApplicationContext());


            // Create layout parameters for ImageView
            LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);


            // Add layout parameters to ImageView
            iv.setLayoutParams(lp);
            Log.d("Log", stringList.get(k));
            loadImageByInternetUrl(iv,stringList.get(k));

            mCustomPagerAdapter.instantiateItem(mViewPager,k,iv);
        }

        //final int[] sampleImages = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4, R.drawable.image_5};



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    private void loadImageByInternetUrl(ImageView imageView1,String internetUrl) {
        Glide
                .with(this)
                .load(internetUrl)
                .into(imageView1);
    }
    public void Info(String[] msg)
    {

    }
    public static List<String> extractUrls(String text)
    {
        List<String> containedUrls = new ArrayList<String>();
        String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher urlMatcher = pattern.matcher(text);

        while (urlMatcher.find())
        {
            containedUrls.add(text.substring(urlMatcher.start(0),
                    urlMatcher.end(0)));
        }

        return containedUrls;
    }
}
