<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<div id="register-form" style="margin-top:30px;">
    <div id="register-form-card" class="card border border-warning border-3">
      <div id="register-message"></div>
      <h3 class="d-flex justify-content-center">注册</h3>
      <form class="row g-3">
        <div class="col-12">
          <label for="name" class="form-label">用户名</label>
          <input type="text" class="form-control" id="name" name="name" placeholder="请输入您的用户名">
        </div>
        <div class="col-12">
          <label for="mobile" class="form-label">手机号</label>
          <input type="text" class="form-control" id="mobile" name="mobile" placeholder="请输入您的手机号">
        </div>
        <div class="col-12">
          <label for="password" class="form-label">密码</label>
          <input type="password" class="form-control" id="password" name="password" placeholder="请输入您的密码">
        </div>
        <div class="col-12">
          <label for="password-again" class="form-label">再次输入密码</label>
          <input type="password" class="form-control" id="password-again" placeholder="请再次确认您的密码">
        </div>
        <div class="col-12">
          <div class="form-check">
            <input class="form-check-input" type="checkbox" id="agreement-check">
            <label class="form-check-label" for="gridCheck">
                同意《隐私保护声明》和《用户使用协议》 
            </label>
          </div>
        </div>
        <div class="col-12 d-flex justify-content-center">
          <button type="button" class="btn btn-primary" onclick="register()">注册</button>
        </div>
      </form>
    </div>
</div>
