package demo01.extend;
/*
һ���̳еĸ���
�̳���Ҫ����������ǹ��Գ�ȡ
���������������ԣ���װ�ԡ��̳��ԡ���̬��
�̳��Ƕ��ĵ�ǰ�ᣬ���û�м̳У���û�ж�̬
             �̳�
���ࣨ�����ࣩ---->���ࣨ���ࡢ���ࣩ
�̳й�ϵ���ص�
1.�������ӵ�и���ġ����ݡ�
2.���໹����ӵ���Լ�ר�е�����
���������ʽ
�ڼ̳й�ϵ�С��������һ�����ࡱ
�磺��ʦ�����ࣩ����һ��Ա�������ࣩ
��ʽ���£�
public class ��������{

}
public class �������� extends ��������{
}
����java�̳е������ص�
1.java�����ǵ��̳еġ���һ���׵�ֱ�Ӹ���ֻ����Ψһһ����
class A(){
}
class B() extends A{
}//��ȷ
class C(){
}
class D() extends A,C{
}//����
2.java���Կ��Զ༶�̳�.��߼���java.lang.Object��
class A(){
}
class B() extends A{
}
class C() extends B{
}//��ȷ
3.һ�������ֱ�Ӹ�����Ωһ�ģ�����һ���������ӵ�ж������
class A(){
}
class B() extends A{
}
class C() extends A{
}//��ȷ
*/
public class Demo01Inherit {
    public static void main(String[] args) {
        Teacher teacher=new Teacher();
        teacher.method();
        Assistant assistant=new Assistant();
        assistant.method();
    }

}
