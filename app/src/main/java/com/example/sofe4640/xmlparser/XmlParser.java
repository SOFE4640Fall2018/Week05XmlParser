package com.example.sofe4640.xmlparser;

import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class XmlParser extends AppCompatActivity {
    LinearLayout ll1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_parser);

        ll1= (LinearLayout) findViewById(R.id.ll1);


        XmlResourceParser parser = getResources().getXml(R.xml.weather);
        try {
            processData(parser);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }


    }

    private void processData(XmlResourceParser parser) throws IOException, XmlPullParserException {
        int eventType =-1;

        while(eventType!= XmlResourceParser.END_DOCUMENT) {
            if(eventType==XmlResourceParser.START_TAG) {
                String locationValue = parser.getName();
                if(locationValue.equals("location")){
                    String city =parser.getAttributeValue(null,"city");
                    String temperature =parser.getAttributeValue(null,"temperature");
                    String weather =parser.getAttributeValue(null,"weather");
                    printvalues(city,temperature,weather);
                }
            }
            eventType = parser.next();
        }
    }

    private void printvalues(String city, String temperature, String weather) {

        LinearLayout weatherData = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT);
        weatherData.setOrientation(LinearLayout.HORIZONTAL);
        params.weight =1;

        TextView cityText = new TextView(this);
        TextView tempertureText = new TextView(this);
        TextView weatherText = new TextView(this);


        cityText.setLayoutParams(params);
        cityText.setText(city);
        weatherData.addView(cityText);
        cityText.setTextSize(24);
        cityText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        tempertureText.setLayoutParams(params);
        tempertureText.setText(temperature);
        weatherData.addView(tempertureText);
        tempertureText.setTextSize(24);
        tempertureText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        weatherText.setLayoutParams(params);
        weatherText.setText(weather);
        weatherData.addView(weatherText);
        weatherText.setTextSize(24);
        weatherText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        ll1.addView(weatherData);
    }

}
