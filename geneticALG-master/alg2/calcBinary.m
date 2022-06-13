function [ out ] = calcBinary( x )
%CALCBINARY Summary of this function goes here
%   Detailed explanation goes here
for i =1 :length(x)
    a = de2bi(abs(x(i)));
    b = zeros(1,14-length(a)-1);
    if sign(x(i))== -1
        temp = [1 a b ];
    else
        temp = [0 a b];
    end
    out(i,:) = temp;
end
end

