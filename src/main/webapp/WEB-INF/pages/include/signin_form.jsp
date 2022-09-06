<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<div id="signin-form" style="margin-top:55px;">
<div id="signin-form-card" class="card border border-warning border-3">
  <div id="signin-message"></div>
  <form class="row g-3">
    <h3 class="d-flex justify-content-center">登录</h3>
    <div class="col-12">
      <label for="name" class="form-label">用户名</label>
      <input type="text" class="form-control" id="name" name="name" placeholder="请输入您的用户名">
    </div>
    <div class="col-12">
      <label for="password" class="form-label">密码</label>
      <input type="password" class="form-control" id="password" name="password" placeholder="请输入您的密码">
    </div>
    <div class="col-12">
      <div class="form-check">
        <input class="form-check-input" type="checkbox" id="gridCheck">
        <label class="form-check-label" for="gridCheck">
             同意《隐私保护声明》和《用户使用协议》 
        </label>
      </div>
    </div>
    <div class="col-12 d-flex justify-content-center">
      <button type="button" class="btn btn-primary" onclick="signin()">登录</button>
    </div>
  </form>
</div>
</div>
