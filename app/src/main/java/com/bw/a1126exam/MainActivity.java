package com.bw.a1126exam;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rec;
    private TextView heji;

    List<MyEntity> list;
    MyAdapder myAdapder;
    int numm = 0;
    private CheckBox quanxuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        list = new ArrayList<>();
        list.add(new MyEntity("6666", false));
        list.add(new MyEntity("8888", false));
        list.add(new MyEntity("7777", false));


        rec.setLayoutManager(new LinearLayoutManager(this));


        myAdapder = new MyAdapder(list);
        rec.setAdapter(myAdapder);

        quanxuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quanxuan.isChecked()) {

                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setIsno(true);
                        myAdapder.notifyDataSetChanged();
                        String num = list.get(i).getNum();

                        int pp = Integer.parseInt(num);
                        numm += pp;
                    }
                    heji.setText(numm + "");
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setIsno(false);
                        myAdapder.notifyDataSetChanged();

                    }
                    numm=0;
                    heji.setText("0");
                }
            }
        });

    }

    private void initView() {
        rec = findViewById(R.id.rec);
        heji = findViewById(R.id.heji);

        quanxuan = findViewById(R.id.quanxuan);
    }

    class MyAdapder extends BaseQuickAdapter<MyEntity, BaseViewHolder> {


        public MyAdapder(@Nullable List<MyEntity> data) {
            super(R.layout.iteam, data);
        }

        @Override
        protected void convert(@NotNull BaseViewHolder baseViewHolder, MyEntity myEntity) {

            TextView view = baseViewHolder.findView(R.id.jg);
            view.setText(myEntity.getNum());

            RadioButton view1 = baseViewHolder.findView(R.id.xz);

            view1.setChecked(myEntity.isIsno());
        }
    }
}