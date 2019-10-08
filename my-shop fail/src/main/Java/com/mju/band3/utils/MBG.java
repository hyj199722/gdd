package com.mju.band3.utils;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import java.io.File;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MBG {
    @Test
    public void fun() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);
    }
    @Test
    public void fun1(){
        String a="c197001010001";
        String b="c201712010010";
        System.out.println(b.compareTo(a));
    }

    @Test
    public void fun2(){
        String a="c201910020001";
        String b="c201910010010";
        int aa = Integer.parseInt(a.substring(9, 13));
        int bb= Integer.parseInt(b.substring(9, 13));
        int c=bb- aa;
        String kkk=a.substring(0,5);
        String substring = a.substring(5, 13);
        int i1 = Integer.parseInt(substring);
        System.out.println("---->"+substring);
            for (int i=0;i<=c;i++){
            System.out.println(kkk+(i1+i));
        }

    }

    @Test
    public void fun3() {
        String a = "c201999999999";
        String b = "c2017120010";
        String regex = "(c|r){1}[2][0-9]{3}[0-9]{8}";
        System.out.println(a.matches(regex));

    }

    @Test
    public void fun4() throws ParseException {
        Date date=new Date();
        System.out.println(date);
        String a="2019-10-02";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse(a);
        System.out.println(parse);

    }
    @Test
    public void fun5()  {
        String a="c201901020001";
        String substring = a.substring(0, 1);
        String b=a.substring(1,13);
        System.out.println(b);
        System.out.println(substring);
        long l = Long.parseLong(b);
        System.out.println(substring+(l+1));



    }


}
