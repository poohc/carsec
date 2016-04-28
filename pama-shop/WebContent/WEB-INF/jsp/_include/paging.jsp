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

<div class="paging">

 <% if ( pageNo > 1 ) { %><a href="javascript:goPage(1);"><img src="<%= webPath %>/images/icon/pag_first.gif" /></a>
 <% } else { %><a href="javascript:void(0)"><img src="<%= webPath %>/images/icon/pag_first.gif" alt="" /></a><% } %>
 <% if ( pageGroup > 1 ) { %><a href="javascript:goPage(<%= startPage - rowNum %>);"><img src="<%= webPath %>/images/icon/pag_prev.gif" alt="" /></a><% } else { %><a href="javascript:void(0);"><img src="<%= webPath %>/images/icon/pag_prev.gif" alt="" /></a><% } %>
 <% for ( int i = startPage, l = endPage + 1 ; i < l ; i++ ) {
     if ( i > startPage ) {
         out.print("<span>|</span>");
     }

     if ( i == pageNo ) {
         out.print("<span class=\"pagingSelected\">" + i + "</span>");
         continue;
     }
     out.print("<span><a href=\"javascript:goPage(" + i + ");\">" + i + "</a></span>");
 }
 %>
 <% if ( pageGroup < totalGroup ) { %><a href="javascript:goPage(<% if ( (endPage + 1) > totalPage ) { out.print(totalPage); } else { out.print(endPage + 1); } %>);"><img src="<%= webPath %>/images/icon/pag_next.gif" alt="" /></a><% } else { %><a href="javascript:void(0);"><img src="<%= webPath %>/images/icon/pag_next.gif" alt="" /></a><% } %>
 <% if ( pageNo < totalPage ) { %><a href="javascript:goPage(<%= totalPage %>);"><img src="<%= webPath %>/images/icon/pag_final.gif" alt="" /></a><% } else { %><a href="javascript:void(0);"><img src="<%= webPath %>/images/icon/pag_final.gif" alt="" /></a><% } %>

</div>
