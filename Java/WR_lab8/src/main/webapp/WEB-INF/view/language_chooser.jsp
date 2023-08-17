<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="form-inline">
    <div class="form-group mr-2">
        <select id="selectLanguage" class="form-control" name='language'
                onchange='this.form.submit()'>
            <cc:choose>
                <%--@elvariable id="userLocale" type="java.util.Locale"--%>
                <cc:when test="${userLocale.language == 'ru'}">
                    <option value='ru' selected>Русский</option>
                    <option value='en'>English</option>
                </cc:when>
                <cc:when test="${userLocale.language == 'en'}">
                    <option value='ru'>Русский</option>
                    <option value='en' selected>English</option>
                </cc:when>
            </cc:choose>
        </select>
    </div>
</form>