package ua.ho.andro.pmtracker.parse;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class RequestTask extends AsyncTask<Void, Void, Void> {
    private String test;
    private String goldResult, goldTrendResult, goldTrend, goldPrise,
            silverResult, silverTrendResult, silverTrend, silverPrise;
    private ProgressDialog dialog;
    @Override
    protected Void doInBackground(Void... params) {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.moneymetals.com/").get();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (doc != null) {
            goldPrise = doc.select("#sp-price-gold").toString();
            goldTrend = doc.select("#sp-icon-gold").toString();
            silverPrise = doc.select("#sp-price-silver").toString();
            silverTrend = doc.select("#sp-icon-silver").toString();
            int q = 4;
        } else
            test = "Ошибка";
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        dialog.dismiss();
        super.onPostExecute(result);
        // stroka
        goldResult = goldPrise.substring(goldPrise.indexOf(">") + 1, goldPrise.lastIndexOf("<"));
        goldTrendResult = goldTrend.substring(goldTrend.indexOf(">") + 1, goldTrend.lastIndexOf("<"));
        silverResult = silverPrise.substring(silverPrise.indexOf(">") + 1, silverPrise.lastIndexOf("<"));
        silverTrendResult = silverTrend.substring(silverTrend.indexOf(">") + 1, silverTrend.lastIndexOf("<"));
//        fetchData();
//        mAdapter = new MLAdapter(MetalListActivity.this, arr);
//        mAdapter.notifyDataSetChanged();
//        mRecyclerView.setAdapter(mAdapter);
//        int t = 5;
    }

    @Override
    protected void onPreExecute() {
//        dialog = new ProgressDialog(MetalListActivity.this);
//        dialog.setMessage("Загружаюсь...");
//        dialog.setIndeterminate(true);
//        dialog.setCancelable(true);
//        dialog.show();
//        super.onPreExecute();
    }
}