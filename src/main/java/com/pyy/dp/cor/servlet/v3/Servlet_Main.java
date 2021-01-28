package com.pyy.dp.cor.servlet.v3;

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
        filterChain.doFilter(request, response, filterChain);
        System.out.println(request.str);
        System.out.println(response.str);
    }
}

class Request {
    String str;
}

class Response {
    String str;
}

interface Filter {
    boolean doFilter(Request request, Response response, FilterChain chain);
}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        request.str = request.str.replaceAll("<", "[").replaceAll(">", "]");
        chain.doFilter(request, response, chain);
        response.str += "--HTMLFilter()";
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        request.str = request.str.replaceAll("996", "955");
        chain.doFilter(request, response, chain);
        response.str += "--SensitiveFilter()";
        return true;
    }
}

class FilterChain implements Filter {

    List<Filter> filters = new ArrayList<>();
    int index = 0;

    public FilterChain add(Filter f) {
        this.filters.add(f);
        return this;
    }

    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        if (index == filters.size()) return false;
        Filter filter = filters.get(index);
        index++;
        return filter.doFilter(request, response, chain);
    }
}
