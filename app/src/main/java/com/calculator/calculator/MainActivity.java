package com.calculator.calculator;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24;
    TextView ans, exp;
    boolean sqrt,facto;

    Vibrator vibrator;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getSupportActionBar().setIcon(R.drawable.calculator);

        b1 = (Button) findViewById(R.id.btn1);
        b2 = (Button) findViewById(R.id.btn2);
        b3 = (Button) findViewById(R.id.btn3);
        b4 = (Button) findViewById(R.id.btn4);
        b5 = (Button) findViewById(R.id.btn5);
        b6 = (Button) findViewById(R.id.btn6);
        b7 = (Button) findViewById(R.id.btn7);
        b8 = (Button) findViewById(R.id.btn8);
        b9 = (Button) findViewById(R.id.btn9);
        b10 = (Button) findViewById(R.id.btn10);
        b11 = (Button) findViewById(R.id.btn11);
        b12 = (Button) findViewById(R.id.btn12);
        b13 = (Button) findViewById(R.id.btn13);
        b14 = (Button) findViewById(R.id.btn14);
        b15 = (Button) findViewById(R.id.btn15);
        b16 = (Button) findViewById(R.id.btn16);
        b17 = (Button) findViewById(R.id.btn17);
        b18 = (Button) findViewById(R.id.btn18);
        b19 = (Button) findViewById(R.id.btn19);
        b20 = (Button) findViewById(R.id.btn20);
        b21 = (Button) findViewById(R.id.btn21);
        b22 = (Button) findViewById(R.id.btn22);
        b23 = (Button) findViewById(R.id.btn23);
        b24 = (Button) findViewById(R.id.btn24);
        exp = (TextView) findViewById(R.id.tvexpression);
        ans = (TextView) findViewById(R.id.tvresult);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(null);
                ans.setText(null);
                sqrt = false;
                facto=false;
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = exp.getText().toString();
                if (str.length() >= 1) {
                    str = str.substring(0, str.length() - 1);
                    exp.setText(str);
                } else if (str.length() <= 1)
                    exp.setText(null);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText() + "√");
                sqrt = true;
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText() + "/");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText() + "7");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText() + "8");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText() + "9");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText() + "×");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText() + "4");
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText() + "5");
            }
        });

        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText() + "6");
            }
        });

        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText() + "-");
            }
        });

        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText() + "1");
            }
        });

        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText() + "2");
            }
        });

        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText() + "3");
            }
        });

        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText() + "+");
            }
        });

        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText() + "0");
            }
        });

        b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText() + ".");
            }
        });

        b20.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                vibrator.vibrate(100);
                try
                {
                    if (sqrt == true)
                    {
                        String str = exp.getText().toString();
                        if (str.charAt(0) == '√')                                                    // For √9
                        {
                            double var1 = Double.parseDouble(str.toString().substring(1));
                            double result = Math.sqrt(var1);

                            ans.setText(result + "");
                        } else                                                                          // For 9√9
                        {
                            int index = str.indexOf('√');
                            double num = Double.parseDouble(str.substring(0, index));

                            double var1 = Double.parseDouble(str.substring(index + 1));
                            double result = Math.sqrt(var1);

                            ans.setText((num * result) + "");
                        }
                        sqrt = false;
                    }
                    else if(facto==true)
                    {
                        String str = exp.getText().toString();
                        str=str.substring(0,str.length()-1);

                        int a = Integer.parseInt(str);
                        int fact=1;
                        for(int i=1;i<=a;i++)
                            fact*=i;

                        ans.setText((fact)+"");

                        facto=false;
                    }
                     else
                     {
                        MainActivity ob = new MainActivity();
                        String str = exp.getText().toString();

                        Stack<Character> s = new Stack<Character>();
                        Stack<Double> op_s = new Stack<Double>();

                        for (int i = 0; i < str.length(); i++) {
                            char ch = str.charAt(i);
                            if (ch == '(')
                                s.push('(');
                            else if (ch == ')') {
                                while (s.peek() != '(') {
                                    double r = op_s.peek();
                                    op_s.pop();
                                    double l = op_s.peek();
                                    op_s.pop();
                                    double re = ob.calculate(s.peek(), l, r);
                                    op_s.push(re);
                                    s.pop();
                                }
                                s.pop();
                            } else if (ch == '+' || ch == '-' || ch == '×' || ch == '/' || ch == '^') {
                                double pC = ob.pri(ch);
                                while (!s.empty() && ob.pri(s.peek()) >= pC) {
                                    double r = op_s.peek();
                                    op_s.pop();
                                    double l = op_s.peek();
                                    op_s.pop();
                                    double re = ob.calculate(s.peek(), l, r);
                                    op_s.push(re);
                                    s.pop();
                                }
                                s.push(ch);
                            } else {
                                String val = "";
                                while (i < str.length() && (Character.isDigit(str.charAt(i)) || str.charAt(i) == '.')) {
                                    if (str.charAt(i) != '.')
                                        val += str.charAt(i) - '0';
                                    else
                                        val += '.';
                                    i++;
                                }
                                op_s.push(Double.valueOf(val));
                                i--;
                            }
                        }
                        while (!s.empty()) {
                            double r = op_s.peek();
                            op_s.pop();
                            double l = op_s.peek();
                            op_s.pop();
                            double re = ob.calculate(s.peek(), l, r);
                            op_s.push(re);
                            s.pop();
                        }
                        ans.setText(Double.toString(op_s.peek()));
                    }
                }
                catch (Exception e)
                {
                    vibrator.vibrate(300);

                    Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText() + "(");
            }
        });

        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText() + ")");
            }
        });

        b23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText() + "^");
            }
        });

        b24.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                exp.setText(exp.getText() + "!");
                facto=true;
            }
        });

        Toolbar toolbar = findViewById(R.id.tool_Bar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerlayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        getWindow().setStatusBarColor(getResources().getColor(R.color.brown, this.getTheme()));
    }

    double pri(char ch) {
        switch (ch) {
            case '(':
                return 1;
            case '+':
            case '-':
                return 2;
            case '×':
            case '/':
                return 3;
            case '^':
                return 4;
        }
        return -1;
    }

    double calculate(char op, double l, double r) {
        if (op == '+')
            return l + r;
        else if (op == '-')
            return l - r;
        else if (op == '×')
            return l * r;
        else if (op == '/') {
            if (r > 0)
                return l / r;
            return 0;
        } else if (op == '^')
            return Math.pow(l, r);
        return -1;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerlayout);
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
            return true;
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_help) {
            Intent intent = new Intent(this, Help.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Here is the share content body";
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerlayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void openActivity2()
    {
        Intent intent = new Intent(this, Stopwatch.class);
        startActivity(intent);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
       // drawerListener.syncState();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}