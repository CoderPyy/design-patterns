package com.pyy.dp.cor.servlet.v4;

import java.util.ArrayList;
import java.util.List;

public class Servlet_Main {
    public static void main(String[] args) {
        Request request = new Request();
        request.str = "大家好:)，<script>，欢迎访问 mashibing.com ，大家都是996 ";
        Response response = new Response();
        response.str = "response";

        FilterChain filterChain = new FilterChain();
        filterChain.add(new HTMLFilter()).add(new SensitiveFilter());
        filterChain.doFilter(request, response);
        System.out.println(request.str);
        System.out.println(response.str);//倒序输出
    }
}

class Request {
    String str;
}

class Response {
    String str;
}

interface Filter {
    void doFilter(Request request, Response response, FilterChain chain);
}

class HTMLFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.str = request.str.replaceAll("<", "[").replaceAll(">", "]");
        chain.doFilter(request, response);
        response.str += "--HTMLFilter()";
    }
}

class SensitiveFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.str = request.str.replaceAll("996", "955");
        chain.doFilter(request, response);
        response.str += "--SensitiveFilter()";
    }
}

class FilterChain {

    List<Filter> filters = new ArrayList<>();
    int index = 0;

    public FilterChain add(Filter f) {
        this.filters.add(f);
        return this;
    }

    public void doFilter(Request request, Response response) {
        if (index == filters.size()) return;
        Filter filter = filters.get(index);
        index++;
        filter.doFilter(request, response, this);
    }
}
