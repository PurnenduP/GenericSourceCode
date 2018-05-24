import java.util.*;
public class THanoi {

	int[] source;
	int[] dest;
	int[] helper;
	Hashtable<Integer,String> ObjectMapper;
	
	
	int size;
	
	THanoi(int size)
	{
		this.size = size;
		source = new int[size];
		dest = new int[size];
		helper = new int[size];
		
		ObjectMapper = new Hashtable<Integer,String>();
		ObjectMapper.put(source.hashCode(),"x");
		ObjectMapper.put(dest.hashCode(),"y");
		ObjectMapper.put(helper.hashCode(),"z");
		
		
		for(int i =0;i<size;i++)
		{
			source[i]= size-i;
			dest[i]=0;
			helper[i]=0;
		}
	}
	
	
	
	
	public void display_all()
	{
		display("x",source);
		display("y",dest);
		display("z",helper);
		
	}
	
//	public int[] copyStack(int[] a)
//	{
//		int temp[] = new int[size];
//		while(!a.isEmpty())
//		{
//			
//		}
//		return temp;
//	}
	
	public void display(String name,int[] arr)
	{
		if(name=="")
		{name="Unknown";}
		System.out.print(name+arr.hashCode()+"=");
		for (int i = 0; i < arr.length; i++) 
		{
			System.out.print(arr[i]);
			if(i<arr.length-1)
			{System.out.print(",");}
			
		}
		System.out.println();
	}
	
	public int pop(int[] arr)
	{
		int temp;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==0)
			{
				if(i>=1)
				{
				temp = arr[i-1];
				arr[i-1]=0;
				return temp;
				}
			}
		}
		temp = arr[size-1];
		arr[size-1]=0;
		return temp;
	}
	
	public void push(int[] arr,int val)
	{
		for (int i = 0; i < arr.length; i++) {
			
			if(arr[i]==0)
			{
				arr[i]=val;
				break;
			}
		}
	}
	
	public void swap(int[] x,int[] y)
	{
		int temp = pop(x);
		push(y,temp);
	}
	
    public int no_of_disks(int[] x)
    {
    	int disk_count=0;
    	for (int i = 0; i < x.length; i++) {
			if(x[i]!=0)
			{
				disk_count++;
			}
		}
    	return disk_count;
    }
	
	public boolean is_swap_possible(int[] x,int[] y)
	{
		int top_x=0;
		int top_y=0;
		for (int i = 0; i < x.length; i++) {
			if(x[i]!=0)
			{
				top_x++;
			}
			else
			{
				break;
			}
		}
		for (int i = 0; i < y.length; i++) {
			if(y[i]!=0)
			{
				top_y++;
			}
			else
			{
				break;
			}
		}
		
		if(top_x==0)
		{
			return false;
		}
		else if(top_x !=0 && top_y==0)
		{
			return true;
		}
		else if(top_x !=0 && top_y!=0)
		{
			if(x[top_x-1] >y[top_y-1])
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		return true;
	}
	public void SolveTowerOfHanoi_Recusion(int n,int[] x,int[] y,int[] z)
	{
		if(n>=1)
		{
			SolveTowerOfHanoi_Recusion(n-1,x,z,y);
			swap(x,y);
			System.out.println(ObjectMapper.get(x.hashCode())+ObjectMapper.get(y.hashCode()));
			display_all();
			SolveTowerOfHanoi_Recusion(n-1, z, y, x);			
		}
		
	}
	
	public boolean solution_found()
	{
		int disk_count=0;
		for (int i = 0; i < dest.length; i++) {
			if(dest[i]!=0)
			{disk_count++;}
		}
				
		if (disk_count==size)
			return true;
		else
			return false;
	
	}
	
		
	
	public void SolveTowerOfHanoi_Iterative(int n,int[] x,int[] y,int[] z)
	{
			
		while(true)
		{			
			if(solution_found()){break;}
			
			while(true)
			{
				if(no_of_disks(x)%2==0)
				{
					if(is_swap_possible(x, z))
					{
						swap(x,z);
						if(solution_found()){break;}
						display_all();
					}
					else
					{
						break;
					}
				}
				else
				{
					if(is_swap_possible(x, y))
						{
						swap(x,y);
						if(solution_found()){break;}
						display_all();
						}
					else
					{
						break;
					}
					
				}
			}
			if(solution_found()){break;}
			while(true)
			{

				if(no_of_disks(y)%2==0)
				{
					if(is_swap_possible(y, x))
					{
						swap(y,x);
						if(solution_found()){break;}
						display_all();
					}
					else
					{
						break;
					}
				}
				else
				{
					if(is_swap_possible(y, z))
					{
						swap(y,z);
						if(solution_found()){break;}
						display_all();
					}
					else
					{
						break;
					}
					
				}
			}
			while(true)
			{
				if(no_of_disks(x)%2==0)
				{
					if(is_swap_possible(x, z))
					{
						swap(x,z);
						if(solution_found()){break;}
						display_all();
					}
					else
					{
						break;
					}
				}
				else
				{
					if(is_swap_possible(x, y))
						{
						swap(x,y);
						if(solution_found()){break;}
						display_all();
						}
					else
					{
						break;
					}
					
				}
			}
			if(solution_found()){break;}

			if(solution_found()){break;}
			while(true)
			{
				if(no_of_disks(z)%2==0)
				{
					if(is_swap_possible(z, x))
					{
						swap(z,x);
						if(solution_found()){break;}
						display_all();
					}
					else
					{
						break;
					}
				}
				else
				{
					if(is_swap_possible(z, y))
					{
						swap(z,y);
						if(solution_found()){break;}
						display_all();
					}
					else
					{
						break;
					}
					
				}
			}			
			
		}
		
		
	}
	
	public static void main(String[] args)
	{
		THanoi t = new THanoi(4);
		
		t.SolveTowerOfHanoi_Iterative(t.size, t.source, t.dest, t.helper);
		t.display_all();
//		t.display("source",t.source);
//		t.display("dest",t.dest);
//		t.display("helper",t.helper);
	}
	
}
