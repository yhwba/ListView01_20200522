package kr.co.yhw.listview01_20200522;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import kr.co.yhw.listview01_20200522.adapters.StudentAdapter;
import kr.co.yhw.listview01_20200522.databinding.ActivityMainBinding;
import kr.co.yhw.listview01_20200522.datas.Student;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding;

    List<Student> ourClassStudentList = new ArrayList<>();
    StudentAdapter mStudentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        binding.studentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                학생 한명을 누르면 , 그 사람의 이름을 Toast로 출력

                Student clickedStudent = ourClassStudentList.get(position);

                Toast.makeText(mContext, clickedStudent.getName(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void setValues() {
        addStudents();

        mStudentAdapter = new StudentAdapter(mContext, R.layout.student_list_item, ourClassStudentList);
        binding.studentListView.setAdapter(mStudentAdapter);
    }

    void addStudents(){
        ourClassStudentList.add(new Student("조경진", "서울시 은평구"));
        ourClassStudentList.add(new Student("강희진", "인천시 남동구"));
        ourClassStudentList.add(new Student("구현정", "서울시 종로구"));
        ourClassStudentList.add(new Student("김정민", "서울시 도봉구"));
        ourClassStudentList.add(new Student("김하늬", "서울시 성북구"));
        ourClassStudentList.add(new Student("문희원", "서울시 은평구"));
        ourClassStudentList.add(new Student("송세인", "서울시 은평구"));
        ourClassStudentList.add(new Student("위건", "서울시 성동구"));
        ourClassStudentList.add(new Student("유혜원", "서울시 은평구"));
        ourClassStudentList.add(new Student("이다연", "서울시 은평구"));
        ourClassStudentList.add(new Student("황보석", "인천시 남동구"));
    }
}
