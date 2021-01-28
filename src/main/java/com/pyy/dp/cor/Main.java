package com.pyy.dp.cor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:)，<script>，欢迎访问 mashibing.com ，大家都是996 ");

        FilterChain filterChain = new FilterChain();
        filterChain.add(new HTMLFilter()).add(new SensitiveFilter());

        FilterChain f2 = new FilterChain();
        f2.add(new FaceFilter()).add(new UrlFilter());

        filterChain.add(f2);

        filterChain.doFilter(msg);
        System.out.println(msg);
    }
}

class Msg {
    String name;
    String msg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}

interface Filter {
    boolean doFilter(Msg m);
}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Msg m) {
        String r = m.getMsg();
        r = r.replace('<', '[');
        r = r.replace('>', ']');
        m.setMsg(r);
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Msg m) {
        String r = m.getMsg();
        r = r.replaceAll("996", "955");
        m.setMsg(r);
        return true;
    }
}

class FaceFilter implements Filter {

    @Override
    public boolean doFilter(Msg m) {
        String r = m.getMsg();
        r = r.replace(":)", "^V^");
        m.setMsg(r);
        return true;
    }
}

class UrlFilter implements Filter {

    @Override
    public boolean doFilter(Msg m) {
        String r = m.getMsg();
        r = r.replace("mashibing.com", "http://www.mashibing.com");
        m.setMsg(r);
        return true;
    }
}

class FilterChain implements Filter {

    private List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter filter) {
        this.filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Msg m) {
        for (Filter f : filters) {
            if (!f.doFilter(m)) return false;
        }
        return true;
    }
}


