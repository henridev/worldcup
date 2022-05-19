<form action='${pageContext.request.contextPath}/logout' method='post'>
  <input type="submit"  class="w-30 btn btn-primary" value="Log out" />
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>