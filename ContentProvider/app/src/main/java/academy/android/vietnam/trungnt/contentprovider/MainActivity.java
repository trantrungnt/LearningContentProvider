package academy.android.vietnam.trungnt.contentprovider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.ContentValues;
import android.database.Cursor;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAddName(View view){
        ContentValues values = new ContentValues();

        values.put(StudentsProvider.NAME, ((EditText) findViewById(R.id.txtName)).getText().toString());
        values.put(StudentsProvider.GRADE, ((EditText) findViewById(R.id.txtGrade)).getText().toString());

        Uri uri = getContentResolver().insert(StudentsProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(), uri.toString(), Toast.LENGTH_LONG).show();
    }

    public void onClickRetrieveStudents (View view){
        String URI = "content://provider.College/students";
        Uri students = Uri.parse(URI);
        Cursor c =  managedQuery(students, null, null, null, "name");
        if(c.moveToFirst()){
            do{
                Toast.makeText(this, c.getString(c.getColumnIndex(StudentsProvider._ID)) +
                        ", " + c.getString(c.getColumnIndex(StudentsProvider.NAME)) +
                        ", " + c.getString(c.getColumnIndex(StudentsProvider.GRADE)), Toast.LENGTH_LONG).show();
            }while (c.moveToNext());
        }
    }
}
