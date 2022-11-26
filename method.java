package doublelinked;

public class method {
	public Node head;
	public Node tail;
	
	public void insertionSort()
	{
		Node currNode = this.head.nextNode;
		while(currNode != null)
		{
			Node nextNode = currNode.nextNode;
			Node searchNode = currNode.prevNode;
			while(searchNode != null && currNode.info < searchNode.info)
			{
				searchNode = searchNode.prevNode;
			}
			removeAt(currNode);
			if(searchNode == null)
			{
				currNode.prevNode = null;
				Next(currNode);
			}
			else
			{
				Post(searchNode, currNode);
				
			}
			currNode = nextNode;
		}
	}
	
	public void Post(Node currNode, Node newNode)
	{
		if(this.head == null)
		{
			this.head = newNode;
			this.tail = newNode;
		}
		else if(currNode == this.tail)
		{
			this.tail.nextNode = newNode;
			newNode.prevNode = this.tail;
			this.tail = newNode;
		}
		else
		{
			Node postNode = currNode.nextNode;
			newNode.nextNode = postNode;
			newNode.prevNode = currNode;
			currNode.nextNode = newNode;
			postNode.prevNode = newNode;
		}
	}
	
	public void Next(Node newNode)
	{
		if(this.head == null)
		{
			this.head = newNode;
			this.tail = newNode;
		}
		else
		{
			newNode.nextNode = this.head;
			this.head.prevNode = newNode;
			this.head = newNode;
		}
	}
	
	public void removeAt(Node currNode)
	{
		Node postNode = currNode.nextNode;
		Node prevNode = currNode.prevNode;
		
		if(postNode != null)
		{
			postNode.prevNode = prevNode;
		}
		if(prevNode != null)
		{
			prevNode.nextNode = postNode;
		}
		if(currNode == this.head)
		{
			this.head = postNode;
		}
		if(postNode == this.tail)
		{
			this.tail = prevNode;
		}
	}
	
	public void systemOut(Node newNode)
	{
		if(this.head == null)
		{
			this.head = newNode;
			this.tail = newNode;
		}
		else
		{
			this.tail.nextNode = newNode;
			newNode.prevNode = this.tail;
			this.tail = newNode;
		}
	}
	
	public void print()
	{
        Node currNode = head;
 
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        while (currNode != null) {
            System.out.print(currNode.info + " ");
            currNode = currNode.nextNode;
        }
 
        System.out.println();
	}
}