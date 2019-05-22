package com.splash.user.first;

/**
 * Created by user on 19-02-2019.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

import com.splash.user.first.QuizContract.*;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="register.db";
    public static final String TABLE_NAME="register";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="REG_NO";
    public static final String COL_4="EMAIL";
    public static final String COL_5="PASSWORD";

    public static final String TABLE_NAME1="notice";
    public static final String COL_11="SNO";
    public static final String COL_22="DATE";
    public static final String COL_33="NOTICE";

    private SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db=db;

        db.execSQL("CREATE TABLE "+ TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT ,NAME TEXT,REG_NO TEXT,EMAIL TEXT,PASSWORD TEXT)");
        db.execSQL("CREATE TABLE "+TABLE_NAME1+"(SNO INTEGER PRIMARY KEY AUTOINCREMENT,DATE DATE,NOTICE TEXT)");
        db.execSQL("CREATE TABLE "+QuestionTable.TABLE_NAME2+"("+
                QuestionTable._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                QuestionTable.COLUMN_QUESTION+" TEXT, "+
                QuestionTable.COLUMN_OPTION1+" TEXT, "+
                QuestionTable.COLUMN_OPTION2+" TEXT, "+
                QuestionTable.COLUMN_OPTION3+" TEXT, "+
                QuestionTable.COLUMN_OPTION4+" TEXT, "+
                QuestionTable.COLUMN_ANSWER_NR+" INTEGER, "+
                QuestionTable.COLUMN_DIFFICULTY+" TEXT, "+
                QuestionTable.COLUMN_CATEGORY+" TEXT"+
                ")");

        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS "+QuestionTable.TABLE_NAME2);
        onCreate(db);
    }

    private void fillQuestionsTable(){
        Question q1=new Question("The cost price of 10 articles is equal to the selling price of 9 articles.find the profit percent",
                "101/9%","100/9%","102/9%","103/9%",2,Question.DIFFICULTY_EASY,Question.CATEGORY_QUANTITATIVE);
        addQuestion(q1);
        Question q2=new Question("In how many ways can the 7 letters A,B,C,D,E,F and G be arranged so that C and E never together?",
                "5040","6480","3600","1440",3,Question.DIFFICULTY_EASY,Question.CATEGORY_QUANTITATIVE);
        addQuestion(q2);
        Question q3=new Question("The ratio of radii of two night circular cylinders is 6:7 and their height are in the ratio 5:9.The ratio of their respective curved surface areas is ",
                "14:15","17:19","23:29","10:21",4,Question.DIFFICULTY_EASY,Question.CATEGORY_QUANTITATIVE);
        addQuestion(q3);
        Question q4=new Question("If 1/2x+1/4x+1/8x=14. Then value of x is",
                "8","12","4","16", 4,Question.DIFFICULTY_EASY,Question.CATEGORY_QUANTITATIVE);
        addQuestion(q4);
        Question q5=new Question("Find the simple interest on Rs.306.25 from March 3rd to July 27th(in the same year) at 3.75",
                "4.57","4.59","4.53","4.58",2,Question.DIFFICULTY_EASY,Question.CATEGORY_QUANTITATIVE);
        addQuestion(q5);
        Question q6=new Question("The L.C.M. of two numbers is 4800 and their G.C.M. is 160. If one of the numbers is 480,then the other number is",
                "1600","1800","2100","2600",1,Question.DIFFICULTY_MEDIUM,Question.CATEGORY_QUANTITATIVE);
        addQuestion(q6);
        Question q7=new Question("The L.C.M. of two numbers is  140.If their ratio is 2:5,then the numbers are ",
                "28,70","28,7","8,70","8,40",1,Question.DIFFICULTY_MEDIUM,Question.CATEGORY_QUANTITATIVE);
        addQuestion(q7);
        Question q8=new Question("If a number is exactly divisible by 85 then what will be the remainder when the same number is divided by 17",
                "3","1","4","0",4,Question.DIFFICULTY_MEDIUM,Question.CATEGORY_QUANTITATIVE);
        addQuestion(q8);
        Question q9=new Question("If x=3+31/2,then what is the value of x^2+9/x^2",
                "15+3*31/2","18+3*31/2","27+3*31/2","None Of These",4,Question.DIFFICULTY_MEDIUM,Question.CATEGORY_QUANTITATIVE);
        addQuestion(q9);
        Question q10=new Question("Which is the closest approximation to the product 0.3333*0.25*0.499*0.125*24",
                "1/8","3/4","3/8","2/5",1,Question.DIFFICULTY_MEDIUM,Question.CATEGORY_QUANTITATIVE);
        addQuestion(q10);
        Question q11=new Question("The simplification of (0.2*0.2+0.02*0.02-0.4*0.02)/0.36",
                "0.009","0.09","0.9","9",2,Question.DIFFICULTY_HARD,Question.CATEGORY_QUANTITATIVE);
        addQuestion(q11);
        Question q12=new Question("If 13+23+33+...+93=2025,then the value of (0.11)^3+(0.22)^3+......+(0.99)^3 is close to ",
                "0.2695","0.3695","2.695","3.695",3,Question.DIFFICULTY_HARD,Question.CATEGORY_QUANTITATIVE);
        addQuestion(q12);
        Question q13=new Question("Which among the following is greatest 51/2,111/3,1231/6 ",
                "51/2","111/3","1231/6","All are equal",1,Question.DIFFICULTY_HARD,Question.CATEGORY_QUANTITATIVE);
        addQuestion(q13);
        Question q14=new Question("What are the unit's digits of 369,6864,4725 respectively",
                "9,6 and 6","6,6 and 6","3,6 and 4","None of these",3,Question.DIFFICULTY_HARD,Question.CATEGORY_QUANTITATIVE);
        addQuestion(q14);
        Question q15=new Question("A= 11*22*33*44*55*.....*1010.How many zeroes will be there at the end of A  ",
                "6","15","10","None of these",2,Question.DIFFICULTY_HARD,Question.CATEGORY_QUANTITATIVE);
        addQuestion(q15);

        Question q16=new Question("Select the word or phrase which best express the meaning of the given word: AVERT",
                "entertain","tranform","turn away","displease",3,Question.DIFFICULTY_EASY,Question.CATEGORY_VERBAL);
        addQuestion(q16);
        Question q17=new Question("Select the word or phrase which best express the meaning of the given word: CITE",
                "visualise","galvanise","locate","quote",4,Question.DIFFICULTY_EASY,Question.CATEGORY_VERBAL);
        addQuestion(q17);
        Question q18=new Question("Select the word or phrase which best express the meaning of the given word: CORPULENT",
                "obese","regenerate","different","hungry",1,Question.DIFFICULTY_EASY,Question.CATEGORY_VERBAL);
        addQuestion(q18);
        Question q19=new Question("Select the word or phrase which best express the meaning of the given word: EMACIATED",
                "garrulous","primeval","disparate","thin", 4,Question.DIFFICULTY_EASY,Question.CATEGORY_VERBAL);
        addQuestion(q19);
        Question q20=new Question("Select the word or phrase which best express the meaning of the given word: GARNISH",
                "PAINT","GARNER","ADORN","ABUSE",3,Question.DIFFICULTY_EASY,Question.CATEGORY_VERBAL);
        addQuestion(q20);
        Question q21=new Question("BOTANY:PLANTS::",
                "GEOLOGY:EARTH","GLOBAL:UNIVERSE","TEACHER:CLASS","DISEASE:ETIOLOGY",1,Question.DIFFICULTY_MEDIUM,Question.CATEGORY_VERBAL);
        addQuestion(q21);
        Question q22=new Question("SATURATED:WET::",
                "ACRID:ACIDIC","DISTANT:FARAWAY","DAMP:DRENCHED","ARID:DRY",4,Question.DIFFICULTY_MEDIUM,Question.CATEGORY_VERBAL);
        addQuestion(q22);
        Question q23=new Question("CAPRICIOUS:FIXED::",
                "LAUGHTER:JOY","AGITATED:UNJEASY","FICKLE:DECISIVE","BIASED:JUDGMENTAL",3,Question.DIFFICULTY_MEDIUM,Question.CATEGORY_VERBAL);
        addQuestion(q23);
        Question q24=new Question("EAST:ORIENTAL::",
                "WEST:OCCIDENTAL","GLOBAL:UNIVERSAL","FOREST:JUNGLE","WEST:EAST",1,Question.DIFFICULTY_MEDIUM,Question.CATEGORY_VERBAL);
        addQuestion(q24);
        Question q25=new Question("HINT:SUGGESTION::",
                "SHADE:SPECTRUM","TRACE:EXISTENCE","NUANCE:DISTINCTION","REMNANT:PRESERVATION",4,Question.DIFFICULTY_MEDIUM,Question.CATEGORY_VERBAL);
        addQuestion(q25);
        Question q26=new Question("Gandhi ....... the cause of the untouchables.",
                "blessed","held","advocated","argued",3,Question.DIFFICULTY_HARD,Question.CATEGORY_VERBAL);
        addQuestion(q26);
        Question q27=new Question("HAMMER:IRONSMITH:: ",
                "CAR:DRIVER","SEEDS:FARMER","AXE:WOODCUTTER","MEDICINE:DOCTOR",3,Question.DIFFICULTY_HARD,Question.CATEGORY_VERBAL);
        addQuestion(q27);
        Question q28=new Question("The ........ rites of the Black Magic cult were kept secret by the members and were never ....... outsiders.",
                "eclectic...delegated","esoteric...divulged","elusive...prescribed","All of them",2,Question.DIFFICULTY_HARD,Question.CATEGORY_VERBAL);
        addQuestion(q28);
        Question q29=new Question("Synonym of VAUNT",
                "LACK","SUFFERANCE","BOAST","NONE OF THESE",3,Question.DIFFICULTY_HARD,Question.CATEGORY_VERBAL);
        addQuestion(q29);
        Question q30=new Question("Opposite of RELAX ",
                "REST","UNWIND","EASE","RELEGATE",4,Question.DIFFICULTY_HARD,Question.CATEGORY_VERBAL);
        addQuestion(q30);
        Question q31=new Question("In ..... if parent process terminates, then all of its children processes must also be terminated ",
                "Process termination ","Serial termination","Parallel termination","Cascading termination",4,Question.DIFFICULTY_EASY,Question.CATEGORY_COMPUTER_PROGRAMMING);
        addQuestion(q31);
        Question q32=new Question("No. of tuples in a relation is called ..... and no. of attributes is called .....",
                "Domain,Cardinality","Degree,Cardinality","Cardinality,Degree","None of above", 3,Question.DIFFICULTY_EASY,Question.CATEGORY_COMPUTER_PROGRAMMING);
        addQuestion(q32);
        Question q33=new Question("What is the default subnet mask for class C network?",
                "127.0.0.1","255.0.0.0","255.255.0.0","255.255.255.o",4,Question.DIFFICULTY_EASY,Question.CATEGORY_COMPUTER_PROGRAMMING);
        addQuestion(q33);
        Question q34=new Question("What is the maximum size of header of IP?",
                "32","54","28","60",4,Question.DIFFICULTY_EASY,Question.CATEGORY_COMPUTER_PROGRAMMING);
        addQuestion(q34);
        Question q35=new Question("The first line of HTTP request message is called ..,....",
                "request line","Header line","Status line","Entrity line ",1,Question.DIFFICULTY_EASY,Question.CATEGORY_COMPUTER_PROGRAMMING);
        addQuestion(q35);
        Question q36=new Question("The ....... method when used in the method field,leaves entity body empty",
                "Post","Send","Get","Put",3,Question.DIFFICULTY_MEDIUM,Question.CATEGORY_COMPUTER_PROGRAMMING);
        addQuestion(q36);
        Question q37=new Question("Which type of ethernet frame is used for TCP/IP and DEC net ",
                "Ethernet802.3","Ethernet 802.2","Ethernet II","Ethernet snap",3,Question.DIFFICULTY_MEDIUM,Question.CATEGORY_COMPUTER_PROGRAMMING);
        addQuestion(q37);
        Question q38=new Question("In tunnel mode IPsec protects the ",
                "Entire ip packet","IP header","IP payload","None",1,Question.DIFFICULTY_MEDIUM,Question.CATEGORY_COMPUTER_PROGRAMMING);
        addQuestion(q38);
        Question q39=new Question("WPA2 is used for security in",
                "Ethernet","Bluetooth","Wifi","None Of These",3,Question.DIFFICULTY_MEDIUM,Question.CATEGORY_COMPUTER_PROGRAMMING);
        addQuestion(q39);
        Question q40=new Question("PGP is useed in ",
                "Browser security","Email security","Ftp security","None",2,Question.DIFFICULTY_MEDIUM,Question.CATEGORY_COMPUTER_PROGRAMMING);
        addQuestion(q40);
        Question q41=new Question("Network layer firewall works as a",
                "Frame filter","Packet filter","Both","None",2,Question.DIFFICULTY_HARD,Question.CATEGORY_COMPUTER_PROGRAMMING);
        addQuestion(q41);
        Question q42=new Question("The cookie manipulation is done by using which property",
                "Cookie","Cookies","Manipulate","None",1,Question.DIFFICULTY_HARD,Question.CATEGORY_COMPUTER_PROGRAMMING);
        addQuestion(q42);
        Question q43=new Question("Which of the following explains cookies nature",
                "Non volatile","Volatile","Intransient","Transient",4,Question.DIFFICULTY_HARD,Question.CATEGORY_COMPUTER_PROGRAMMING);
        addQuestion(q43);
        Question q44=new Question("Which attribute is used to extend the lifetime of the cookie",
                "Higherage","Increaseage","Maxage","Lifetime",3,Question.DIFFICULTY_HARD,Question.CATEGORY_COMPUTER_PROGRAMMING);
        addQuestion(q44);
        Question q45=new Question("To remove a realtion from sql datanbase we use the ..... command ",
                "Delete","Purge","Remove","Drop table",4,Question.DIFFICULTY_HARD,Question.CATEGORY_COMPUTER_PROGRAMMING);
        addQuestion(q45);

        Question q46=new Question("Look at the series 7,10,8,11,9,12..... what number should come next",
                "7","10","12","13",2,Question.DIFFICULTY_EASY,Question.CATEGORY_LOGICAL);
        addQuestion(q46);
        Question q47=new Question("Look at the series 36,34,30,28,24,..... what number should come next",
                "20","22","23","26",2,Question.DIFFICULTY_EASY,Question.CATEGORY_LOGICAL);
        addQuestion(q47);
        Question q48=new Question("Look at the series 201,202,204,207,..... what number should come next",
                "205","208","210","211",4,Question.DIFFICULTY_EASY,Question.CATEGORY_LOGICAL);
        addQuestion(q48);
        Question q49=new Question("Which word does not belong with others",
                "Parsley","Basil","Dill","Mayonnaise", 4,Question.DIFFICULTY_EASY,Question.CATEGORY_LOGICAL);
        addQuestion(q49);
        Question q50=new Question("Which word does not belong with the others",
                "Tulip","Rose","Bird","Daisy",3,Question.DIFFICULTY_EASY,Question.CATEGORY_LOGICAL);
        addQuestion(q50);
        Question q51=new Question("SCD,EEF,UGH,...,WKL",
                "CMN","UJI","VIJ","IJT",3,Question.DIFFICULTY_MEDIUM,Question.CATEGORY_LOGICAL);
        addQuestion(q51);
        Question q52=new Question("FAG,GAF,HAI,IAH,....",
                "JAK","HAL","HAK","JAI",1,Question.DIFFICULTY_MEDIUM,Question.CATEGORY_LOGICAL);
        addQuestion(q52);
        Question q53=new Question("Find the next number in the sequence 15,31,63,127,255,..",
                "110","170","511","181",3,Question.DIFFICULTY_MEDIUM,Question.CATEGORY_LOGICAL);
        addQuestion(q53);
        Question q54=new Question("If + means /, * means - , - means * , and / means + then 38+19-16*17/3 = ?" ,
                "16","19","18","12",3,Question.DIFFICULTY_MEDIUM,Question.CATEGORY_LOGICAL);
        addQuestion(q54);
        Question q55=new Question("1,2,3,1,4,9,1,...,27",
                "5","4","16","8",4,Question.DIFFICULTY_MEDIUM,Question.CATEGORY_LOGICAL);
        addQuestion(q55);
        Question q56=new Question("6,5,24,25,144,....",
                "155","160","170","175",4,Question.DIFFICULTY_HARD,Question.CATEGORY_LOGICAL);
        addQuestion(q56);
        Question q57=new Question("12yr old Rahul is 3times as  old as his brother Raj.How old will rahul be when he is twice as old as Raj",
                "16","18","20","14",1,Question.DIFFICULTY_HARD,Question.CATEGORY_LOGICAL);
        addQuestion(q57);
        Question q58=new Question("What comes after 4,16,64.......",
                "128","256","224","512",2,Question.DIFFICULTY_HARD,Question.CATEGORY_LOGICAL);
        addQuestion(q58);
        Question q59=new Question("A 4 cats, 6 people and 3 dogs have how many legs",
                "36","40","32","NONE OF THESE",2,Question.DIFFICULTY_HARD,Question.CATEGORY_LOGICAL);
        addQuestion(q59);
        Question q60=new Question("9,3,16,4,36,6,81,...",
                "12","9","46","24",2,Question.DIFFICULTY_HARD,Question.CATEGORY_LOGICAL);
        addQuestion(q60);
    }


    private void addQuestion(Question question){
        ContentValues cv=new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuestionTable.COLUMN_OPTION1,question.getOption1());
        cv.put(QuestionTable.COLUMN_OPTION2,question.getOption2());
        cv.put(QuestionTable.COLUMN_OPTION3,question.getOption3());
        cv.put(QuestionTable.COLUMN_OPTION4,question.getOption4());
        cv.put(QuestionTable.COLUMN_ANSWER_NR,question.getAnswerNr());
        cv.put(QuestionTable.COLUMN_DIFFICULTY,question.getDifficulty());
        cv.put(QuestionTable.COLUMN_CATEGORY,question.getCategory());
        db.insert(QuestionTable.TABLE_NAME2,null,cv);
    }

    public List<Question> getAllQuestions(){
        List<Question> questionList=new ArrayList<>();
        db=getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+ QuestionTable.TABLE_NAME2,null);
        if(c.moveToFirst()){
            do{
                Question question=new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionTable.COLUMN_DIFFICULTY)));
                question.setCategory(c.getString(c.getColumnIndex(QuestionTable.COLUMN_CATEGORY)));
                questionList.add(question);
            }while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    public List<Question> getQuestions(String difficulty,String category){
        List<Question> questionList=new ArrayList<>();
        db=getReadableDatabase();

        String[] selectionArgs=new String[]{difficulty,category};
        Cursor c=db.rawQuery("SELECT * FROM "+QuestionTable.TABLE_NAME2+
                " WHERE "+QuestionTable.COLUMN_DIFFICULTY+" = ? "+
                " AND "+QuestionTable.COLUMN_CATEGORY+" = ?",selectionArgs);

        if(c.moveToFirst()){
            do{
                Question question=new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionTable.COLUMN_DIFFICULTY)));
                question.setCategory(c.getString(c.getColumnIndex(QuestionTable.COLUMN_CATEGORY)));
                questionList.add(question);
            }while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    public boolean insertData(String date,String notice){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_22,date);
        contentValues.put(COL_33,notice);
        long result=db.insert(TABLE_NAME1,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }

    public Cursor ViewData(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+TABLE_NAME1,null);
        return cursor;
    }


public void updateUserInfo(DatabaseHelper dbr, String old_email ,String new_pass )
{
    SQLiteDatabase db = dbr.getWritableDatabase();
    String selection = DatabaseHelper.COL_4+ " LIKE ?";
    String args[]={old_email};
    ContentValues values = new ContentValues();
    values.put(DatabaseHelper.COL_5,new_pass);
   db.update(DatabaseHelper.TABLE_NAME,values,selection,args);

}




}
