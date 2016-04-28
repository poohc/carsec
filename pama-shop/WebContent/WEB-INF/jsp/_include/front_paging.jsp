<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    String webPath = "";
    int totalCount = Integer.parseInt(request.getParameter("count"));
    int rowNum = Integer.parseInt(request.getParameter("row"));
    int pageNo = Integer.parseInt(request.getParameter("page"));

    int totalPage = (int) Math.ceil( totalCount / ( rowNum * 1.0 ) );
    if ( totalPage == 0 ) totalPage = 1;
    int pageGroup = (int) Math.ceil( pageNo / ( 10 * 1.0 ) );
    int totalGroup = (int) Math.ceil( totalPage / ( 10 * 1.0 ) );
    int startPage = ( ( pageGroup - 1 ) * 10 ) + 1;
    int endPage = pageGroup * 10 ;
    if ( totalPage < endPage ) endPage = totalPage;
%>

<%-- <% if ( pageNo > 1 ) { %> --%>
<!-- <a href="javascript:goPage(1);" class="page_first">첫 페이지로</a> -->
<%-- <% } else { %> --%>
<!-- <a href="javascript:void(0)" class="page_first">첫 페이지로</a> -->
<%-- <% } %> --%>

<% if ( pageNo > 1 ) { %>
<a href="javascript:goPage(<%= pageNo - 1 %>);" class="prev">이전</a>
<% } else { %>
<a href="javascript:void(0);" class="prev">이전</a>
<% } %>



 <% for ( int i = startPage, l = endPage + 1 ; i < l ; i++ ) {

// 	 if ( i > startPage ) {
//          out.print("");
//      }

     if ( i == pageNo ) { //현재페이지
         out.print("<a href=\"javascript:goPage(" + i + ");\" class=\"on\">" + i + "</a>");
         continue;
     }
     out.print("<a href=\"javascript:goPage(" + i + ");\" >" + i + "</a>");
 }
 %>

 <% if ( pageNo < totalPage ) { %>
 <a href="javascript:goPage(<%=  pageNo + 1  %>);"  class="next">다음</a>
 <% } else { %>
 <a href="javascript:void(0);"  class="next">다음</a>
 <% } %>


<%--  <% if ( pageNo < totalPage ) { %> --%>
<%--  <a href="javascript:goPage(<%= totalPage %>);" class="page_end">마지막 페이지로</a> --%>
<%--  <% } else { %> --%>
<!--  <a href="javascript:void(0);" class="page_end">마지막 페이지로</a> -->
<%--  <% } %> --%>

