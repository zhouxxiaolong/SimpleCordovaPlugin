package com.zxl.helloplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created
 * 创 建 人: @author zhouxiaolong
 * 创建日期: 2019/3/6
 * 邮   箱: 1016579848@qq.com
 * 参   考: @link
 * 描   述:
 */
public class NewActivity extends Activity {

    public static final String EXTRA_STRING = "extra_string";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //！！！注释为错误写法！！！
        //setContentView(R.layout.layout_new_activity);
        String package_name = getApplication().getPackageName();
        setContentView(getApplication().getResources().getIdentifier("layout_new_activity", "layout", package_name));

        EditText editText = findViewById(getApplication().getResources().getIdentifier("et_content", "id", package_name));

        findViewById(getApplication().getResources().getIdentifier("btn_back", "id", package_name)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.putExtra(EXTRA_STRING, editText.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
