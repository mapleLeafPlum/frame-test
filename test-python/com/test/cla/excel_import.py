import xlrd  # 导入模块
import xlwt


def read_excel():
    data = xlrd.open_workbook('D:/download/abc.xls')  # 打开电影.xlsx文件读取数据
    table = data.sheets()[0]  # 读取第一个（0）表单
    # 或者通过表单名称获取 table = data.sheet_by_name(u'Sheet1')
    print(table.nrows)  # 输出表格行数
    print(table.ncols)  # 输出表格列数
    print(table.row_values(0))  # 输出第一行
    print(table.col_values(0))  # 输出第一列
    print(table.cell(1, 0).value)  # 输出元素（0,2）的值
    print(table.cell(1, 1).value)  # 输出元素（0,2）的值
    print(table.cell(1, 2).value)  # 输出元素（0,2）的值
    print(table.cell(1, 3).value)  # 输出元素（0,2）的值


def write_excel():
    wb = xlwt.Workbook(encoding='ascii')  # 创建新的Excel（新的workbook），建议还是用ascii编码
    ws = wb.add_sheet('weng')  # 创建新的表单weng
    ws.write(0, 0, label='hello')  # 在（0,0）加入hello
    ws.write(0, 1, label='world')  # 在（0,1）加入world
    ws.write(1, 0, label='你好')
    wb.save('D:/download/writes.xls')  # 保存为weng.xls文件


if __name__ == '__main__':
    write_excel()
pass
