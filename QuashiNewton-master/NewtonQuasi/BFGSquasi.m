function [ min,itt,ak ] = DFPquasi( f,start,e,f1 )
start = start';
g = gradient(f);
H = eye(length(start));
xk = start;
ak = 1;
gk = double(g(xk(1),xk(2)));
k = 1;
while norm(gk,2)>e
    if gk == 0
        break;
    else
        dk = -(H*gk);
    end
        xkn = xk+dk;
        gkn = double(g(xkn(1),xkn(2)));
        dgk = (gkn - gk);
        tk = dgk'*H*dgk;
        uk = dk/(dk'*dgk) - (H*dgk)/tk;
         H = H+((dk-H*dgk)*(dk-H*dgk)'/(dgk'*(dk-H*dgk)))+0*tk*uk*uk';
        xk = xkn;
        ppoint(xk,double(f (xk(1),xk(2))),f1);
        gk = gkn;
        k = k+1;
end
hold on
shading interp
plot3(xk(1),xk(2),double(f (xk(1),xk(2))), 'r*');
min = xk;
fprintf('total steps for DFP method are %d\n',k)


end

