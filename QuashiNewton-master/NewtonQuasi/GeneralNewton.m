function min = GeneralNewton(f,start,e)

xk= num2cell(start);

itt = 1;
param = symvar(f);
grad = gradient(f,param);

dgradv = double(norm(grad(xk{:}),2));
ak = 1;
fprintf('with ak = %d\n',ak)
while dgradv>=e
    H = hessian(f);
    H = H(xk{:});
    pk = double(-((inv(H)))*(grad(xk{:})));
    xk = cell2mat(xk) + double((ak*pk)');
    xk = num2cell(xk);
    dgradv = double(norm(grad(xk{:}),2));
    itt = itt+1;
end

min = xk;
min2 = cell2mat(min);
fprintf("min = %d %d,itterations needed = %d\n",min2(1),min2(2),itt);

end