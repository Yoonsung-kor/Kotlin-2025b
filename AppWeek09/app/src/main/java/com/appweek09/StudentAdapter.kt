package com.appweek09

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appweek09.data.Student
import com.appweek09.databinding.ItemStudentBinding

class StudentAdapter(
    private val studentList: List<Student>,
    private val onItemClick: (Student, Int) -> Unit,
    private val onItemLongClick: (Int) -> Unit
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>(){

    inner class StudentViewHolder(
        private val binding: ItemStudentBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(student : Student){
            binding.apply{
                textViewName.text = student.name
                textViewDept.text = student.department
                textViewGrade.text = student.grade
                textViewEmail.text = student.email

                root.setOnClickListener {
                    onItemClick(student, adapterPosition);
                }

                root.setOnLongClickListener {
                    onItemLongClick(adapterPosition)
                    true
                }
            }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = ItemStudentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return StudentViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(studentList[position])
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = studentList.size
}