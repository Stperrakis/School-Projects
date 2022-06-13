%%genetic 9.5

clc
clear
close all
[x,y] = meshgrid([-10:10],[-10:10]);
z =  100.*((y-x.^2)^2)+(1-x).^2;
surf(x,y,z)
sym x
hold on

cforcemut = 0;
cross = 1;
nvar = 2 ;
stop = 10^-3;
popNum = 400;
startP = [-12,1];
tolera= [-3,3];
starfval = func1(startP);
pmutat = 0.4;
indistop = 0;
SelectionP = 0.5;
%creating population
pop = CreatePop(nvar,popNum,tolera,startP);
gen = 1;
numgen = 100;
while(indistop==0&&gen<numgen)
    for i = 1: size(pop,1)
        fval(i) = func1(pop(i,:));
        if gen ~=1
        if fval(i)<=stop
            solution(1,:) = [pop(i,1),pop(i,2),fval(i)];
            indistop = 1;
            break;
        end
        end
    end
    
    
    sfval = sum(fval);
    minfval = min(fval);
    
    pnorm =  minfval/sfval;
    
    for i = 1: size(pop,1)
        pcurrent=(pnorm/((fval(i))/sfval));
        totalS(i,:) = [pop(i,1),pop(i,2),fval(i),pcurrent];
    end
    totalS = sortrows(totalS,3);
    sizeSel = size(totalS,1);
    
    sizeSel = sizeSel*SelectionP;
    
    parents = ParentSelect(sizeSel,totalS);
    counter = 1;
    
%     if totalS(1,1)==pop(1,1)&&totalS(1,2)==pop(1,2)
%         cforcemut = cforcemut+1;
%         if(cforcemut/numgen>0.1)
%             [ch1,ch2] = CrossOver(totalS(1,1:2),totalS(randi([2 fix(size(totalS,1)/2)]),1:2),nvar,1,cross);
%             newpop(1,:)=ch1;
%             newpop(2,:)=ch2;
%             counter = 3;
%             cforcemut = 1;
%         end
%     end

 newpop(counter,:)= [totalS(1,1),totalS(1,2)];
    
    
    for i =1 : size(parents,1)
       in = 0;
        a = randi([1 size(totalS,1)]);
        [ch1,ch2] = CrossOver( parents(i,1:2),totalS(a,1:2),nvar,pmutat,cross);
        if func1([parents(i,1:2)])>=func1(ch1)
        newpop(counter,:)= ch1;
        else
            in = 1;
        newpop(counter,:) = [parents(i,1:2)];
        end
        counter = counter+1;
        
        if func1([parents(i,1:2)])>=func1(ch2)||in~=1
        newpop(counter,:)=ch2;
        else
        newpop(counter,:) = [parents(i,1:2)];
        end
        
        counter = counter+1;
    end
    
    fprintf("Generation :%d \n Bestx:%f Besty:%f , fval:%f \n",gen,totalS(1,1),totalS(1,2),totalS(1,3));
    plot3(totalS(1,1),totalS(1,2),totalS(1,3),'o')
    popMemorium(gen).population = pop;
    popMemorium(gen).totalS = totalS;
    gen = gen+1;
    pop = [];
    pop = newpop;
end

















