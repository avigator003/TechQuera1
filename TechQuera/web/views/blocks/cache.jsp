<% 

response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if(session.getAttribute("user")==null)
response.sendRedirect("/pro/web/login1");


%>